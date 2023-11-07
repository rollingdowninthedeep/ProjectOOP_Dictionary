package DictionaryApp.Controller;

import DictionaryApp.Feature.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Addition extends Study implements Initializable {
    @FXML
    private TextField addTextField;

    @FXML
    private ListView<String> searchListView;

    @FXML
    private Button saveButton;

    @FXML
    private Label titleLabel, contentLabel;

    @FXML
    private TextArea targetText, meaningText;

    @FXML
    private AnchorPane mainPane, addingPane, showingPane;

    @FXML
    public void addFieldAction() {
        String s = addTextField.getText();
        if (s == null) s = "";
        if (!s.isBlank()) {
            addingPane.setVisible(true);
            targetText.setText(s);
            meaningText.setText(null);

            setList(s);
            if (!list.isEmpty()) {
                saveButton.setDisable(true);

                searchListView.getItems().clear();
                searchListView.setItems(list);
                System.out.println(searchListView.getItems().size());
            } else {
                saveButton.setDisable(false);

                searchListView.getItems().clear();
            }
        } else {
            saveButton.setDisable(true);

            addingPane.setVisible(false);

            searchListView.getItems().clear();
        }
    }

    @FXML
    public void onSaveAction() {
        Word word = new Word(targetText.getText(), meaningText.getText());
        wordList.insertWord(word);

        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/Views/Search.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onCancelAction() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/Views/Search.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        searchListView.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item);
                    }
                }
            };
            cell.setOnMouseEntered(e -> showWord(cell.getText()));
            cell.setOnMouseExited(e -> hideWord());
            return cell;
        });
    }

    public void showWord(String word) {
        int index = wordList.searchWord(word);
        if (index != -1) {
            titleLabel.setText(word);
            contentLabel.setText(wordList.getWordArrayList().get(index).getMeaning());
            showingPane.setVisible(true);
        }
    }

    public void hideWord() {
        showingPane.setVisible(false);
    }

    public void setList(String keyWord) {
        if (keyWord.isBlank()) {
            ObservableList<String> list = FXCollections.observableArrayList();
            for (Word word : wordList.getWordArrayList()) {
                list.add(word.getOrigin());
                if (list.size() == 30) break;
            }
            this.list = list;
        } else {
            this.list = wordList.lookUpWord(keyWord);
        }
    }
}

package com.example.dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Search extends Study implements Initializable {
    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<String> searchListView = new ListView<>();

    @FXML
    private TextArea titleText;
    @FXML
    private TextArea contentText;
    @FXML
    private TextArea targetText;
    @FXML
    private TextArea meaningText;

    @FXML
    private AnchorPane mainPane, resultArea;
    @FXML
    private AnchorPane fixingArea;

    @FXML
    public void searchFieldAction() {
        fixingArea.setVisible(false);
        resultArea.setVisible(false);

        String s = searchTextField.getText();
        setList(s);
        if (!list.isEmpty()) {
            searchListView.getItems().clear();
            searchListView.setItems(list);
        } else {
            searchListView.getItems().clear();
            searchListView.setPlaceholder(new Label("No result!"));
        }
    }

    @FXML
    public void onMouseClickedAction() {
        String word = searchListView.getSelectionModel().getSelectedItem();
        if (word != null) {
            Word selectedWord = wordList.getWordArrayList().get(wordList.searchWord(word));
            titleText.setText(selectedWord.getOrigin());
            contentText.setText(selectedWord.getMeaning());
            resultArea.setVisible(true);
            fixingArea.setVisible(false);
        } else {
            titleText.setText(null);
            contentText.setText(null);
            resultArea.setVisible(false);
        }
    }
    @FXML
    public void onSpeechAction() {
        speechEngine.speak(titleText.getText());
    }

    @FXML
    public void onAddAction() {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Addition.fxml"));
            mainPane.getChildren().clear();
            mainPane.getChildren().add(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onUpdateAction() {
        targetText.setText(titleText.getText());
        targetText.setEditable(false);
        meaningText.setText(contentText.getText());

        resultArea.setVisible(false);
        fixingArea.setVisible(true);
    }

    @FXML
    public void onSaveAction() {
        Word word = new Word(targetText.getText(), meaningText.getText());
        wordList.updateWord(word);

        fixingArea.setVisible(false);
    }

    @FXML
    public void onDeleteAction() {
        String word = searchListView.getSelectionModel().getSelectedItem();
        wordList.deleteWord(word);
        searchTextField.setText(null);
        setList("");
        searchListView.setItems(list);

        resultArea.setVisible(false);
    }

    private ObservableList<String> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setList("");
        searchListView.setItems(list);
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

package DictionaryApp.Controller;

import DictionaryApp.Feature.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import static DictionaryApp.Controller.DictionaryController.wordList;

public abstract class SearchDisplay extends Display{
    @FXML
    protected TextField searchTextField;

    @FXML
    protected ListView<String> searchListView = new ListView<>();
    @FXML
    public abstract void searchFieldAction();

    protected ObservableList<String> list = FXCollections.observableArrayList();

    protected void setList(String keyWord) {
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

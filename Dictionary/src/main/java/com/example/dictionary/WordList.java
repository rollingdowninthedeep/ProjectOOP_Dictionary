package com.example.dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordList {
    private static final String DEFAULT_TABLE = "tbl_edict";
    private static final String DEFAULT_ORIGINCOLUMN = "word";
    private static final String DEFAULT_MEANINGCOLUMN = "detail";
    private final DatabaseConnection databaseConnection = new DatabaseConnection();
    private ArrayList<Word> wordArrayList = new ArrayList<>();
    private Trie trie = new Trie();

    public WordList(){
        importFromData(DEFAULT_TABLE, DEFAULT_ORIGINCOLUMN, DEFAULT_MEANINGCOLUMN);
    }
    public void importFromData(String tableName, String originColumn, String meaningColumn) {
        Connection connection = databaseConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            String command = "SELECT * FROM " + tableName;
            ResultSet resultSet = statement.executeQuery(command);
            while(resultSet.next()){
                Word word = new Word(resultSet.getString(originColumn), resultSet.getString(meaningColumn));
                this.wordArrayList.add(word);
                this.trie.insertWord(word.getOrigin());
            }
            if(!tableName.equals(DEFAULT_TABLE)) exportToData();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void exportToData(){

    }
    public int dataSize(){
        return wordArrayList.size();
    }
    public ObservableList<String> lookUpWord(String keyWord){
        ObservableList<String> list = FXCollections.observableArrayList();
        List<String> results = trie.predictedWords(keyWord);
        if (results != null) {
            int length = Math.min(results.size(), 30);
            for (int i = 0; i < length; i++) list.add(results.get(i));
        }
        return list;
    }
    public int searchWord(String keyWord){
        Comparator<Word> comparator = new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o1.getOrigin().compareTo(o2.getOrigin());
            }
        };
        this.wordArrayList.sort(comparator);
        int left = 0;
        int right = wordArrayList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tmp = wordArrayList.get(mid).getOrigin().compareTo(keyWord);
            if (tmp == 0) return mid;
            if (tmp <= 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public void insertWord(Word word){
        wordArrayList.add(word);
        trie.insertWord(word.getOrigin());
    }
    public void deleteWord(String word) {
        int index = searchWord(word);
        if(index != -1) {
            trie.deleteWord(word);
            wordArrayList.remove(index);
        }
    }
    public void updateWord(Word newWord){
        wordArrayList.get(searchWord(newWord.getOrigin())).setMeaning(newWord.getMeaning());
    }
    public ArrayList<Word> getWordArrayList() {
        return wordArrayList;
    }

    public static void main(String[] args) {
        WordList wordList = new WordList();
        System.out.println(wordList.dataSize());
        wordList.deleteWord("cat");
        System.out.println(wordList.dataSize());
        String keyWord = "butt";
        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList = wordList.lookUpWord(keyWord);
        for(String s: observableList){
            System.out.println(s);
        }
    }
}

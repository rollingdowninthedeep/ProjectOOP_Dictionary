package DictionaryApp.Wordle.Feature;

import DictionaryApp.DictionaryApplication;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class WordList {

    private static WordList currentWordList;
    private String theWord = "";
    private Set<Integer> usedIndices = new HashSet<>();
    private List<String> words = new ArrayList<>();
    private Random rand = new Random();

    private WordList() {
        System.out.println("building word data");
        try {
            InputStream inputStream = DictionaryApplication.class.getResourceAsStream("/data/wordlist.txt");
            assert inputStream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            words = reader.lines().toList();
        } catch (Exception e){
            e.printStackTrace();
        }
        if(!words.isEmpty()) System.out.println("Load Complete!");
        else System.out.println("Error loading");
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("STACK");
//        arrayList.add("THICK");
//        arrayList.add("THANK");
//        arrayList.add("BRICK");
//        words = arrayList;
    }

    public static WordList getCurrentWordList(){
        if(currentWordList == null){
            currentWordList = new WordList();
        }
        return currentWordList;
    }
    public String getTheWord() {
        return theWord;
    }

    public boolean isAWord(String guess) {
        return words.stream().anyMatch(w -> w.equals(guess));
    }

    int index;

    public void setNewWord() {
        do {
            index = rand.nextInt(words.size());
        } while (!usedIndices.add(index));

        theWord = words.get(index);
        System.out.println("theWord = " + theWord + ", index =" + index);
    }

}


package DictionaryApp.Wordle.Feature;

import DictionaryApp.Wordle.Item.LetterStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GameStatus {

    private static GameStatus currentGameStatus;
    private List<LetterState>letterState = new ArrayList<>();
    private Map<String, LetterStyle.DisplayType> keyBoardState = new HashMap<>();
    private final WordStats wordStats = new WordStats();

    private GameStatus(){}
    public static GameStatus getCurrentGameStatus(){
        if(currentGameStatus == null) {
            currentGameStatus = new GameStatus();
        }
        return currentGameStatus;
    }
    public List<LetterState> getLetterState() {
        return letterState;
    }

    public Map<String, LetterStyle.DisplayType> getKeyBoardState() {
        return keyBoardState;
    }
    
    public WordStats getWordStats() {
        return this.wordStats;
    }

    public void setLetterState(List<LetterState> letterState) {
        this.letterState = letterState;
    }

    public void setKeyBoardState(Map<String, LetterStyle.DisplayType> keyBoardState) {
        this.keyBoardState = keyBoardState;
    }
       
}



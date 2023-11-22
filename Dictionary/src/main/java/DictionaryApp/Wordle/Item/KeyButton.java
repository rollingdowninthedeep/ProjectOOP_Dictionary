package DictionaryApp.Wordle.Item;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;

import static DictionaryApp.Wordle.Item.LetterStyle.*;
import static DictionaryApp.Wordle.Item.LetterStyle.DisplayType.PLAIN;

public class KeyButton extends Button {

    public KeyButton() {
        super();
        getStyleClass().add("matching-letter");
        getStyleClass().add("nomatch-letter");
        getStyleClass().add("partialmatch-letter");
        getStyleClass().add("plain-letter");
    }
    
    private final ObjectProperty<DisplayType> letterDisplay = new SimpleObjectProperty<>(PLAIN) {
        @Override
        public void invalidated() {
            pseudoClassStateChanged(PLAIN_PSEUDO_CLASS, false);
            pseudoClassStateChanged(NOMATCH_PSEUDO_CLASS, false);
            pseudoClassStateChanged(PARTIALMATCH_PSEUDO_CLASS, false);
            pseudoClassStateChanged(MATCHING_PSEUDO_CLASS, false);
            switch (get()) {
                case PLAIN -> pseudoClassStateChanged(PLAIN_PSEUDO_CLASS, true);
                case NOMATCH -> pseudoClassStateChanged(NOMATCH_PSEUDO_CLASS, true);
                case PARTIALMATCH -> pseudoClassStateChanged(PARTIALMATCH_PSEUDO_CLASS, true);
                case MATCHING -> pseudoClassStateChanged(MATCHING_PSEUDO_CLASS, true);
                default -> pseudoClassStateChanged(PLAIN_PSEUDO_CLASS, true);
            }
        }
    };
    
    public void setLetterDisplay(LetterStyle.DisplayType labelType) {
        this.letterDisplay.set(labelType);
    }

    public LetterStyle.DisplayType getLetterDisplay() {
        return letterDisplay.get();
    }
    

}

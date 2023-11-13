package DictionaryApp.Feature;

import com.darkprograms.speech.synthesiser.Synthesiser;
import com.darkprograms.speech.synthesiser.SynthesiserV2;
import javafx.fxml.Initializable;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class SpeechEngine {
    private final SynthesiserV2 synthesiserV2 = new SynthesiserV2("AIzaSyBT3HWqg5nsKDhb42nRJgFy3fi0pXk4_DA");

    private class SpeechEngineThread implements Runnable {
        private String text;
        private SynthesiserV2 synthesiserV2;

        public SpeechEngineThread(String text, SynthesiserV2 synthesiserV2) {
            this.text = text;
            this.synthesiserV2 = synthesiserV2;
        }

        @Override
        public void run() {
            try {
                synthesiserV2.setLanguage("en-us");
                InputStream inputStream = synthesiserV2.getMP3Data(text);
                AdvancedPlayer player = new AdvancedPlayer(inputStream);
                player.play();
                player.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void speak(String text) {
        Thread thread = new Thread(new SpeechEngineThread(text, this.synthesiserV2));
        thread.setDaemon(false);
        thread.start();
    }
}

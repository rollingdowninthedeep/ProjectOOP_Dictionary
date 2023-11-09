package DictionaryApp.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Translate implements Initializable {

    @FXML
    private TextArea inputText;

    @FXML
    private TextArea outputText;

    @FXML
    private Label labelVietnamese;

    @FXML
    private Label labelEnglish;

    @FXML
    private Button translateBt;

    private String inLanguage = "en";

    private String outLanguage = "vi";

    private boolean outVietnamese = true;

    @FXML
    public void swap() {
        String tmpLanguage = inLanguage;
        inLanguage = outLanguage;
        outLanguage = tmpLanguage;

        if (outVietnamese) {
            labelEnglish.setLayoutX(522);
            labelVietnamese.setLayoutX(157);
        } else {
            labelVietnamese.setLayoutX(522);
            labelEnglish.setLayoutX(157);
        }

        outVietnamese = !outVietnamese;
        inputText.clear();
        outputText.clear();
    }

    @FXML
    public void translateClick() throws IOException {
        try {
            String urlStr = "https://script.google.com/macros/s/AKfycbyTDUKFOzo-zJf7zFJYoC7ChPiXjfrTT6o0eg6ortIA5FzW01lBSCNmQfoOI6AYG75E/exec" +
                "?q=" + URLEncoder.encode(inputText.getText(), "UTF-8") +
                "&target=" + outLanguage +
                "&source=" + inLanguage;
            URL url = new URL(urlStr);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            connect.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            StringBuilder input = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                input.append(inputLine);
            }
            in.close();
            connect.disconnect();
            String translation = input.toString();
            outputText.setText(translation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        outputText.setEditable(false);
        translateBt.setDisable(true);

        inputText.setOnKeyTyped(event -> {
            translateBt.setDisable(inputText.getText().trim().isEmpty());
        });

        translateBt.setOnAction(event -> {
            try {
                translateClick();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}

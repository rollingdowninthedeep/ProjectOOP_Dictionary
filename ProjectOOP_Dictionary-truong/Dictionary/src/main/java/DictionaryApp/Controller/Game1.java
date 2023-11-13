package DictionaryApp.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class Game1 {

    @FXML
    private AnchorPane game1;
    public Label question;
    public Button A, B, C, D;
    int counter = 0;
    static int correct = 0;
    static int wrong = 0;

    @FXML
    public void initialize() {
        loadQuestion();
    }
    @FXML
    private void loadQuestion() {
        if (counter == 0) {
            question.setText("1 + 1 = ???");
            A.setText("1");
            B.setText("2");
            C.setText("0");
            D.setText("3");
        }
        else {
            question.setText("Con gà có trước hay quả trứng có trước");
            A.setText("Con mèo");
            B.setText("Quả trứng");
            C.setText("Con gà");
            D.setText("Không biết");
        }
    }
    @FXML
    public void a(ActionEvent actionEvent) throws IOException {
        checkAnswer(A.getText().toString());
        if (checkAnswer(A.getText().toString())) {
            correct ++;
        } else {
            wrong++;
        }

        if (counter == 1) {
            try {
                AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1Results.fxml")));
                game1.getChildren().clear();
                game1.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestion();
        }
    }

    @FXML
    public void b(ActionEvent actionEvent) throws IOException {
        checkAnswer(B.getText().toString());
        if (checkAnswer(B.getText().toString())) {
            correct ++;
        }
        else {
            wrong++;
        }

        if (counter == 1) {
            try {
                AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1Results.fxml")));
                game1.getChildren().clear();
                game1.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestion();
        }
    }

    @FXML
    public void c(ActionEvent actionEvent) throws IOException {
        checkAnswer(C.getText().toString());
        if (checkAnswer(C.getText().toString())) {
            correct ++;
        }
        else {
            wrong++;
        }

        if (counter == 1) {
            try {
                AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1Results.fxml")));
                game1.getChildren().clear();
                game1.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestion();
        }
    }

    @FXML
    public void d(ActionEvent actionEvent) throws IOException {
        checkAnswer(D.getText().toString());
        if (checkAnswer(D.getText().toString())) {
            correct ++;
        }
        else {
            wrong++;
        }

        if (counter == 1) {
            try {
                AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1Results.fxml")));
                game1.getChildren().clear();
                game1.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestion();
        }
    }

    boolean checkAnswer(String answer) {
        if (counter == 0) {
            if (answer.equals("2")) return true;
            else return false;
        }
        if (counter == 1) {
            if (answer.equals("Không biết")) return true;
            else return false;
        }
        return false;
    }


    @FXML
    public void back(ActionEvent actionEvent) throws IOException {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/MenuGame1.fxml")));
            game1.getChildren().clear();
            game1.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


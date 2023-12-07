package DictionaryApp.Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.RandomAccessFile;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;



public class Game1 {


    @FXML
    private AnchorPane game1;
    public Label question;
    public Label Cau;
    public Label time;
    public Button A, B, C, D;
    static int counter = 0;
    static int correct = 0;
    static int wrong = 0;
    @FXML
    public void initialize() {
        loadQuestion();
        startTimer();
    }

    // Câu hỏi
    String Question[] = {" _____ raiding for camels was a significant part of Bedouin life has been documented in Wilfed Thesiger’s Arabian Sands.","The little boy pleaded ___ not to leave him alone in the dark.","___, the people who come to this club are in their twenties and thirties.",
        "The TV station, in _____ to massive popular demand, decided notto discontinue the soap opera","His emotional problems _____ from the attitudes he encountered as a child, I think.","Pete was born and brought up in Cornwall and he knows the place like the _______.",
        "British and Australian people share the same language, but in other respects they are as different as ___.","Rows and silences are ____ and parcel of any marriage."," Ancient Egyptians mummified their dead through the use of chemicals, _____ ancient Peruvians did through natural processes.",
        "Don’t ___ to any conclusion before you know the full facts.","A few animals sometimes fool their enemies _____ to be dead.","On no account __ in the office be used for personal materials.","The __ of the bank where he worked was not in the center of the city.",
        "____ from Bill, all the students said they would go.","Position of the main stress","______ my opinion, French cheese is better than English cheese.","When I bought the shoes, they _________ me well but later they were too tight at home","The purpose of phonetics is __ an inventory and a description of the sounds found in speech",
        "They received a ten-year sentence for __armed robbery.","_________ the hijacker plane landed, it was surrounded by police.","This magazine is very good. If you like reading, you should______to it.","In life ___can make a mistake ; We’re all human.","Do you have any objections______this new road scheme?",
        "The police set a_________to catch the thieves.","Although he was _______ , he agreed to play tennis with me"," _____ I didn’t know how to do the job. But now I am making progress.","Language could _____ more quickly if there were more language exchange programs.","She won the award for ______ her whole life to looking after the poor.","Although the exam was difficult, ____ the students passed it.",
        "The mirror was ____ broken.","But for his help, I _______","I may look half asleep, but I can assure you I am ____ awake.","Lefthand traffic, a custom existing in Britain only, _______ back to the days when English people went to and fro on horseback."," “ I am sorry . I broke the vase.” – “_________________.”","The tourists refused to ________ the poor service.",
        "I haven’t got the time to do my own work, _______ help you with yours.","Professor Lockwood recommended that Michael _______ in chemistry.","Luggage may be placed here ______ the owner’s risk.","It’s a serious operation for a woman as old as my grandmother. She is very frail . I hope she ______",
        "______ any other politician would have given way to this sort of pressure years ago.","After several months of hard work, the police are finally ______ somewhere with their investigation.","There’s no danger in using this machine as long as you _______ to the safety regulations."};
    // Câu trả lời
    String options[][] = {
        {"That", "Which", "What", "Where"}, {"on his mother","his mother","with his mother","at his mother"}, {"By and large","Altogether","To a degree","Virtually"}, {"reaction","response","answer","rely"}, {"stem","flourish","root","sprout"}, {"nose on his face","back of his hand","hairs on his head","teeth of his mouth"},
        {"cats and dogs","salt and pepper: muối tiêu (màu tóc)","chalk and cheese: khác nhau hoàn toàn","here and there: đó đây"},{"package","stamps","packet","part"},{"because","whereas","even though","whether or not"},{"rush","dive","leap","fly"},{"have been appearing","to be appearing","to appear","by appearing"},{"the photocopy machines","the photocopy machines should","should the photocopy machines","does the photocopy machines"},
        {"branch","seat","house","piece"},{"Exept","Only","Apart","Separate"},{"vacancy","calculate","delicious","furniture"},{"For","To","By","In"},{"matched","fitted","suited","went with"},{"provide","provided","to provide","being provided"},{"making","doing","committing","practicing"},
        {"As soon as","While","Just","Until"},{"buy","subscribe","contribute","enroll"},{"anyone","someone","some people","not anybody"},{"at","with","to","for"},{"plan","device","snare","trap"},{"exhaustion","exhausted","exhausting","exhaustive"},{"First","First of all","At first","At the first."},
        {"be learning","have learned","have learning","be learned"},{"paying","devoting","causing","attracting"},{"most of","none of","a few","a lot"},{"accident","accidental","accidentally","by accident"},{"would not have succeeded","had not succeeded","did not succeed","would succeed"},{"broad","full","well","wide"},{"dated","dating","dates back","to date"},
        {"Don’t worry. Things break.","OK. Go ahead.","Yes, certainly.","I’d rather not."},{"stand in for ","put up with ","get away from","get on with "},{"leaving aside : ngoại trừ","let alone : huống hồ","apart from : ngoại trừ","not counting : ngoại trừ"},
        {"not to major","not major","wouldn’t major","isn’t majoring"},{"at","by","under","with"},{"gets away : rời đi","comes round : tỉnh lại (become conscious)","pulls through : hồi phục (sức khỏe)","stands up"},{"Really","Practically : thực tế mà nói, gần như","Actually : thực tế là (luôn đứng ở trong câu)","Utterly : hoàn toàn, cực kỳ"},
        {"getting","going","making","doing"},{"comply","adhere","observe","abide"}
    };
    // Random câu hỏi
    Random random = new Random();
    int n = 0;
    // Đếm ngược thời gian
    public int giay = 60;
    public int phut = 9;

    private void startTimer() {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
            new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    updateTimer();
                }
            })
        );
        timeline.play();
    }
    private void updateTimer() {
        giay--;
        time.setText(String.valueOf(phut) + ":" + String.valueOf(giay));
        if (phut == 0 && giay == 0){
            time.setText("Hết giờ");
            try {
                AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1Results.fxml")));
                game1.getChildren().clear();
                game1.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter = 0;
        }
        if (giay <= 0) {phut--;giay = 60;}
    }
    @FXML
    private void loadQuestion() {
        Cau.setText("Câu " + (counter+1));
        question.setText(Question[n]);
        A.setText(options[n][0]);
        B.setText(options[n][1]);
        C.setText(options[n][2]);
        D.setText(options[n][3]);
    }
    @FXML
    public void a(ActionEvent actionEvent) throws IOException {
        checkAnswer(A.getText().toString());
        if (checkAnswer(A.getText().toString())) {
            correct ++;
        } else {
            wrong++;
        }

        if (counter == 19) {
            try {
                AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1Results.fxml")));
                game1.getChildren().clear();
                game1.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter = 0;
        } else {
            counter++;
            n = random.nextInt(42);
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

        if (counter == 19) {
            try {
                AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1Results.fxml")));
                game1.getChildren().clear();
                game1.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter = 0;
        } else {
            counter++;
            n = random.nextInt(42);
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

        if (counter == 19) {
            try {
                AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1Results.fxml")));
                game1.getChildren().clear();
                game1.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter = 0;
        } else {
            counter++;
            n = random.nextInt(42);
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

        if (counter == 19) {
            try {
                AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1Results.fxml")));
                game1.getChildren().clear();
                game1.getChildren().add(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter = 0;
        } else {
            counter++;
            n = random.nextInt(42);
            loadQuestion();
        }
    }

    // Check đáp án
    boolean checkAnswer(String answer) {
        if (n == 0) {
            if (answer.equals("That")) return true;
            else return false;
        }
        if (n == 1) {
            if (answer.equals("with his mother")) return true;
            else return false;
        }
        if (n == 3) {
            if (answer.equals("By and large")) return true;
            else return false;
        }
        if (n == 4) {
            if (answer.equals("response")) return true;
            else return false;
        }
        if (n == 5) {
            if (answer.equals("stem")) return true;
            else return false;
        }
        if (n == 6) {
            if (answer.equals("back of his hand")) return true;
            else return false;
        }
        if (n == 7) {
            if (answer.equals("chalk and cheese: khác nhau hoàn toàn")) return true;
            else return false;
        }
        if (n == 8) {
            if (answer.equals("whereas")) return true;
            else return false;
        }
        if (n == 9) {
            if (answer.equals("leap")) return true;
            else return false;
        }
        if (n == 10) {
            if (answer.equals("by appearing")) return true;
            else return false;
        }
        if (n == 11) {
            if (answer.equals("should the photocopy machines")) return true;
            else return false;
        }
        if (n == 12) {
            if (answer.equals("branch")) return true;
            else return false;
        }
        if (n == 13) {
            if (answer.equals("Apart")) return true;
            else return false;
        }
        if (n == 14) {
            if (answer.equals("delicious")) return true;
            else return false;
        }
        if (n == 15) {
            if (answer.equals("In")) return true;
            else return false;
        }
        if (n == 16) {
            if (answer.equals("fitted")) return true;
            else return false;
        }
        if (n == 17) {
            if (answer.equals("to provide")) return true;
            else return false;
        }
        if (n == 18) {
            if (answer.equals("committing")) return true;
            else return false;
        }
        if (n == 19) {
            if (answer.equals("As soon as")) return true;
            else return false;
        }
        if (n == 20) {
            if (answer.equals("subscribe")) return true;
            else return false;
        }
        if (n == 21) {
            if (answer.equals("anyone")) return true;
            else return false;
        }
        if (n == 22) {
            if (answer.equals("to")) return true;
            else return false;
        }
        if (n == 23) {
            if (answer.equals("trap")) return true;
            else return false;
        }
        if (n == 24) {
            if (answer.equals("exhausted")) return true;
            else return false;
        }
        if (n == 25) {
            if (answer.equals("At first")) return true;
            else return false;
        }
        if (n == 26) {
            if (answer.equals("be learned")) return true;
            else return false;
        }
        if (n == 27) {
            if (answer.equals("devoting")) return true;
            else return false;
        }
        if (n == 28) {
            if (answer.equals("most of")) return true;
            else return false;
        }
        if (n == 29) {
            if (answer.equals("accidentally")) return true;
            else return false;
        }
        if (n == 30) {
            if (answer.equals("would not have succeeded")) return true;
            else return false;
        }
        if (n == 31) {
            if (answer.equals("wide")) return true;
            else return false;
        }
        if (n == 32) {
            if (answer.equals("dates back")) return true;
            else return false;
        }
        if (n == 33) {
            if (answer.equals("Don’t worry. Things break.")) return true;
            else return false;
        }
        if (n == 34) {
            if (answer.equals("put up with")) return true;
            else return false;
        }
        if (n == 35) {
            if (answer.equals("let alone : huống hồ")) return true;
            else return false;
        }
        if (n == 36) {
            if (answer.equals("not major")) return true;
            else return false;
        }
        if (n == 37) {
            if (answer.equals("at")) return true;
            else return false;
        }
        if (n == 38) {
            if (answer.equals("pulls through : hồi phục (sức khỏe)")) return true;
            else return false;
        }
        if (n == 39) {
            if (answer.equals("Practically : thực tế mà nói, gần như")) return true;
            else return false;
        }
        if (n == 40) {
            if (answer.equals("getting")) return true;
            else return false;
        }
        if (n == 41) {
            if (answer.equals("adhere")) return true;
            else return false;
        }
        return false;
    }


    @FXML
    public void back(ActionEvent actionEvent) throws IOException {
        counter = 0;
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/MenuGame1.fxml")));
            game1.getChildren().clear();
            game1.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

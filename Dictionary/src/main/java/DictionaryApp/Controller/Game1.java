package DictionaryApp.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class Game1 extends Display {
    @FXML
    private Label question;
    @FXML
    private Label Cau;
    @FXML
    private Label time;
    @FXML
    private Button A, B, C, D;
    static int counter = 0;
    static int correct = 0;
    static int wrong = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadQuestion();
        startTimer();
    }

    // Câu hỏi
    String[] Question = {" _____ raiding for camels was a significant part of Bedouin life has been documented in Wilfed Thesiger’s Arabian Sands.","The little boy pleaded ___ not to leave him alone in the dark.","___, the people who come to this club are in their twenties and thirties.",
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
    String[][] options = {
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
            new KeyFrame(Duration.seconds(1), event -> updateTimer())
        );
        timeline.play();
    }
    private void updateTimer() {
        giay--;
        time.setText(phut + ":" + giay);
        if (phut == 0 && giay == 0){
            time.setText("Hết giờ");
            try {
                switchScene("/Views/Game1Results.fxml");
            } catch (Exception e) {
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
    public void a() {
        checkAnswer(A.getText());
        if (checkAnswer(A.getText())) {
            correct ++;
        } else {
            wrong++;
        }

        if (counter == 19) {
            try {
                switchScene("/Views/Game1Results.fxml");
            } catch (Exception e) {
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
    public void b() {
        checkAnswer(B.getText());
        if (checkAnswer(B.getText())) {
            correct ++;
        }
        else {
            wrong++;
        }

        if (counter == 19) {
            try {
                switchScene("/Views/Game1Results.fxml");
            } catch (Exception e) {
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
    public void c(){
        checkAnswer(C.getText());
        if (checkAnswer(C.getText())) {
            correct ++;
        }
        else {
            wrong++;
        }

        if (counter == 19) {
            try {
                switchScene("/Views/Game1Results.fxml");
            } catch (Exception e) {
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
    public void d() {
        checkAnswer(D.getText());
        if (checkAnswer(D.getText())) {
            correct ++;
        }
        else {
            wrong++;
        }

        if (counter == 19) {
            try {
                switchScene("/Views/Game1Results.fxml");
            } catch (Exception e) {
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
            return answer.equals("That");
        }
        if (n == 1) {
            return answer.equals("with his mother");
        }
        if (n == 3) {
            return answer.equals("By and large");
        }
        if (n == 4) {
            return answer.equals("response");
        }
        if (n == 5) {
            return answer.equals("stem");
        }
        if (n == 6) {
            return answer.equals("back of his hand");
        }
        if (n == 7) {
            return answer.equals("chalk and cheese: khác nhau hoàn toàn");
        }
        if (n == 8) {
            return answer.equals("whereas");
        }
        if (n == 9) {
            return answer.equals("leap");
        }
        if (n == 10) {
            return answer.equals("by appearing");
        }
        if (n == 11) {
            return answer.equals("should the photocopy machines");
        }
        if (n == 12) {
            return answer.equals("branch");
        }
        if (n == 13) {
            return answer.equals("Apart");
        }
        if (n == 14) {
            return answer.equals("delicious");
        }
        if (n == 15) {
            return answer.equals("In");
        }
        if (n == 16) {
            return answer.equals("fitted");
        }
        if (n == 17) {
            return answer.equals("to provide");
        }
        if (n == 18) {
            return answer.equals("committing");
        }
        if (n == 19) {
            return answer.equals("As soon as");
        }
        if (n == 20) {
            return answer.equals("subscribe");
        }
        if (n == 21) {
            return answer.equals("anyone");
        }
        if (n == 22) {
            return answer.equals("to");
        }
        if (n == 23) {
            return answer.equals("trap");
        }
        if (n == 24) {
            return answer.equals("exhausted");
        }
        if (n == 25) {
            return answer.equals("At first");
        }
        if (n == 26) {
            return answer.equals("be learned");
        }
        if (n == 27) {
            return answer.equals("devoting");
        }
        if (n == 28) {
            return answer.equals("most of");
        }
        if (n == 29) {
            return answer.equals("accidentally");
        }
        if (n == 30) {
            return answer.equals("would not have succeeded");
        }
        if (n == 31) {
            return answer.equals("wide");
        }
        if (n == 32) {
            return answer.equals("dates back");
        }
        if (n == 33) {
            return answer.equals("Don’t worry. Things break.");
        }
        if (n == 34) {
            return answer.equals("put up with");
        }
        if (n == 35) {
            return answer.equals("let alone : huống hồ");
        }
        if (n == 36) {
            return answer.equals("not major");
        }
        if (n == 37) {
            return answer.equals("at");
        }
        if (n == 38) {
            return answer.equals("pulls through : hồi phục (sức khỏe)");
        }
        if (n == 39) {
            return answer.equals("Practically : thực tế mà nói, gần như");
        }
        if (n == 40) {
            return answer.equals("getting");
        }
        if (n == 41) {
            return answer.equals("adhere");
        }
        return false;
    }


    @FXML
    public void back() {
        try {
            switchScene("/Views/MenuGame1.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package DictionaryApp.Wordle.Controller;

import DictionaryApp.Controller.Display;
import DictionaryApp.Wordle.Feature.GameStatus;
import DictionaryApp.Wordle.Feature.WordStats;
import DictionaryApp.Wordle.Wordle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class StatsController extends Display {

    @FXML
    private Label statPlayed;
    @FXML
    private Label statPercent;
    @FXML
    private Label statCurrent;
    @FXML
    private Label statMax;

    @FXML
    private StackPane pane;
    @FXML
    private BarChart<Number, String> barChart;
    @FXML
    private NumberAxis xAxis;
    @FXML
    private CategoryAxis yAxis;

    private final ObservableList<BarChart.Series<Number, String>> bcData
            = FXCollections.observableArrayList();
    private static final GameStatus gameStatus = GameStatus.getCurrentGameStatus();
    private final WordStats ws = gameStatus.getWordStats();
    private ChangeListener<Scene> changeListener;

    @FXML
    private void switchToWordle() throws Exception {
        pane.sceneProperty().removeListener(changeListener);
        switchScene("/Views/wordle-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        barChart.setAnimated(false);
        barChart.setTitle("Guess Distribution");
        barChart.setLegendVisible(false);
        xAxis.setTickLabelsVisible(false);

        statPlayed.setText(String.valueOf(ws.getGamesPlayed()));
        statPercent.setText(String.format("%4.0f", ws.getWinPercentage()));
        statCurrent.setText(String.valueOf(ws.getCurrentStreak()));
        statMax.setText(String.valueOf(ws.getMaxStreak()));
        barChart.setData(installBarChartData());
        barChart.setHorizontalGridLinesVisible(false);
        barChart.setVerticalGridLinesVisible(false);

        pane.sceneProperty().addListener(changeListener
                = (ObservableValue<? extends Scene> observableScene,
                   Scene oldScene, Scene newScene) -> {
            if (oldScene == null && newScene != null) {
                new Timeline(
                        new KeyFrame(Duration.millis(50), ae -> fixLabels()))
                        .play();
            }
        });

    }

    private ObservableList<XYChart.Series<Number, String>> installBarChartData() {
        XYChart.Series<Number, String> series = new XYChart.Series<>();
        ws.getGuessDistribution().keySet().forEach(key -> series.getData().add(0, new Data<>(
                ws.getGuessDistribution().get(key),
                String.valueOf(key))));
        bcData.add(series);
        return bcData;
    }

    public void fixLabels() {
        System.out.println("fixLabels1");
        List<Label> mylabels = pane.getChildren().stream()
                .filter(sc -> sc instanceof Label)
                .map(Label.class::cast)
                .toList();
        mylabels.forEach(l -> {
            l.toFront();
            l.getStyleClass().add("chartlabel");
        });
        Node chartArea = barChart.lookup(".chart-plot-background");
        XYChart.Series<Number, String> series = barChart.getData().get(0);

        IntStream.range(0, series.getData().size())
                .forEach(i -> {
                    Data<Number, String> data = series.getData().get(i);
                    Node node = data.getNode();
                    if (data.getYValue().equals(String.valueOf(ws.getThisGameGuesses()))) {
                        node.setStyle("-fx-bar-fill: -fx-match-color;");
                        mylabels.get(i).setStyle("-fx-background-color: -fx-match-color;");
                    }
                    Bounds nodeBounds = node.localToScene(chartArea.getBoundsInLocal());
                    double displayPositionX = xAxis.getDisplayPosition(data.getXValue());
                    double displayPositionY = yAxis.getDisplayPosition(data.getYValue());
                    mylabels.get(i).setText(data.getXValue().toString());
                    if (displayPositionX == 0.0) {
                        mylabels.get(i).setTranslateX(20 - (nodeBounds.getWidth() / 2));
                        //mylabels.get(i).setTranslateX(-53 - (nodeBounds.getWidth() / 2));
                    } else {
                        mylabels.get(i).setTranslateX(displayPositionX - 4 - ((nodeBounds.getWidth()) / 2));
                        //mylabels.get(i).setTranslateX(displayPositionX - 78 - ((nodeBounds.getWidth()) / 2));
                    }
                    mylabels.get(i).setTranslateY(displayPositionY + 21);
                    mylabels.get(i).setVisible(true);
                });
    }
}

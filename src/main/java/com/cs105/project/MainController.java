package com.cs105.project;

import java.util.Objects;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MainController {
    @FXML
    private VBox mainPane;
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView robot;
    @FXML
    private Button escape;
    @FXML
    private Button forward;
    @FXML
    private Button start;

    private boolean mutualGaze = false;
    private long startTime = 0;
    public int userScore = 0;
    public int robotScore = 0;

    @FXML
    private void onStartButtonClick() {
        welcomeText.setText("Welcome to Cui Inc. Lab!");
        String imageName = null;
        if (mutualGaze = Rand.isCui()) {
            imageName = "robot_mutual.png";
        } else {
            imageName = "robot_avert.png";
        }
        robot.setImage(new Image(Objects.requireNonNull(
                MainApplication.class.getResourceAsStream(imageName))));

        startTime = System.currentTimeMillis();

        start.setDisable(true);
        escape.setDisable(false);
        forward.setDisable(false);
    }

    /**
     * look: 0.7 go straight, 0.3 avoid
     * dont look: 0.7 avoid, 0.3 go straight
     * 
     * @return true: go straight; false: avoid
     */
    private boolean robotChoice() {
        return mutualGaze == Rand.isCui();
    }

    @FXML
    private void onEscapeButtonClick() {
        long endTime = System.currentTimeMillis();
        boolean robotChoice = robotChoice();
        double oldRange = Rand.range;

        String imageName = null;
        if (robotChoice) { // robot go, user avoid
            robotScore = 3;
            userScore = 0;
            if (mutualGaze) {
                Rand.range = 1 - (1 - Rand.range) * (1 - 0.06);
            } else {
                Rand.range *= (1 - 0.06);
            }
            imageName = "safe2.gif";
        } else { // robot avoid, user avoid
            robotScore = 1;
            userScore = 1;
            if (mutualGaze) {
                Rand.range *= (1 - 0.02);
            } else {
                Rand.range = 1 - (1 - Rand.range) * (1 - 0.02);
            }
            imageName = "safe3.gif";
        }
        welcomeText.setText(String.format("Your score: %d\t Robot's score: %d", userScore, robotScore));
        robot.setImage(new Image(Objects.requireNonNull(
                MainApplication.class.getResourceAsStream(imageName))));

        Logger.log(System.currentTimeMillis(), mutualGaze, robotChoice, false, endTime - startTime, robotScore,
                userScore, oldRange);

        start.setDisable(false);
        escape.setDisable(true);
        forward.setDisable(true);
    }

    @FXML
    private void onForwardButtonClick() {
        long endTime = System.currentTimeMillis();
        boolean robotChoice = robotChoice();
        double oldRange = Rand.range;

        String imageName = null;
        if (robotChoice) { // robot go, user go
            robotScore = -4;
            userScore = -4;
            if (mutualGaze) {
                Rand.range *= (1 - 0.08);
            } else {
                Rand.range = 1 - (1 - Rand.range) * (1 - 0.08);
            }
            imageName = "crash1.gif";
        } else { // robot avoid, user go
            robotScore = 0;
            userScore = 3;
            imageName = "safe1.gif";
        }
        welcomeText.setText(String.format("Your score: %d\t Robot's score: %d", userScore, robotScore));
        robot.setImage(new Image(Objects.requireNonNull(
                MainApplication.class.getResourceAsStream(imageName))));

        Logger.log(System.currentTimeMillis(), mutualGaze, robotChoice, true, endTime - startTime, robotScore,
                userScore, oldRange);

        start.setDisable(false);
        escape.setDisable(true);
        forward.setDisable(true);
    }
}
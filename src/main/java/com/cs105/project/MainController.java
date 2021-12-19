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

    // private Thread t;

    // @SuppressWarnings("all")
    // private Thread newThread() {
    // return new Thread(() -> {
    // while (true) {
    // if (blank) {
    // robot.setImage(
    // new Image(Objects.requireNonNull(
    // MainApplication.class.getResourceAsStream("safe.gif"))));
    // } else {
    // robot.setImage(
    // new Image(Objects.requireNonNull(
    // MainApplication.class.getResourceAsStream("crash.gif"))));
    // }
    // blank = !blank;
    // try {
    // Thread.sleep(2000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }
    // });
    // }

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
        return !(mutualGaze ^ Rand.isCui());
    }

    @FXML
    private void onEscapeButtonClick() {
        boolean robotChoice = robotChoice();
        
        if (robotChoice) { // robot go, user avoid
            // TODO score
        }
        else { // robot avoid, user avoid
            
        }
        robot.setImage(new Image(Objects.requireNonNull(
                MainApplication.class.getResourceAsStream("safe.gif"))));
        
        start.setDisable(false);
        escape.setDisable(true);
        forward.setDisable(true);
    }

    @FXML
    private void onForwardButtonClick() {
        boolean robotChoice = robotChoice();
        String imageName = null;
        if (robotChoice) { // robot go, user go
            // TODO score
            imageName = "crash.gif";
        }
        else { // robot avoid, user go
            imageName = "safe.gif";
        }
        robot.setImage(new Image(Objects.requireNonNull(
                MainApplication.class.getResourceAsStream(imageName))));

        start.setDisable(false);
        escape.setDisable(true);
        forward.setDisable(true);
    }
}
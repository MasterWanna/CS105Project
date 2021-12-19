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

    private boolean blank = true;

    private Thread t;

    @SuppressWarnings("all")
    private Thread newThread() {
        return new Thread(() -> {
            while (true) {
                if (blank) {
                    robot.setImage(
                        new Image(Objects.requireNonNull(
                            MainApplication.class.getResourceAsStream("Squirrel.jpeg"))));
                } else {
                    robot.setImage(
                        new Image(Objects.requireNonNull(
                            MainApplication.class.getResourceAsStream("aaa.png"))));
                }
                blank = !blank;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        if (t == null) {
            t = newThread();
            t.start();
        }
    }
}
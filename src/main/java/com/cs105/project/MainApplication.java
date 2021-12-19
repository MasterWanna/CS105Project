package com.cs105.project;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
            new FXMLLoader(MainApplication.class.getResource("project-view.fxml"));
        VBox box = fxmlLoader.load();
        Scene scene = new Scene(box, 240,420);
        stage.setTitle("Project of CUI");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> System.exit(0));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
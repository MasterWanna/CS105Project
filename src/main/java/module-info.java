module com.cs105.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;


    opens com.cs105.project to javafx.fxml;
    exports com.cs105.project;
}
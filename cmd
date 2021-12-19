#!/bin/zsh

mvn clean compile
JAVA_HOME=$(/usr/libexec/java_home -v 11) java -Dfile.encoding=UTF-8 -classpath "$HOME/.m2/repository/org/openjfx/javafx-controls/17.0.1/javafx-controls-17.0.1.jar:$HOME/.m2/repository/org/openjfx/javafx-graphics/17.0.1/javafx-graphics-17.0.1.jar:$HOME/.m2/repository/org/openjfx/javafx-base/17.0.1/javafx-base-17.0.1.jar:$HOME/.m2/repository/org/openjfx/javafx-fxml/17.0.1/javafx-fxml-17.0.1.jar" -p "$HOME/.m2/repository/org/openjfx/javafx-fxml/17.0.1/javafx-fxml-17.0.1-mac-aarch64.jar:$HOME/Desktop/Code/Java/classes/CS105/project/target/classes:$HOME/.m2/repository/org/openjfx/javafx-graphics/17.0.1/javafx-graphics-17.0.1-mac-aarch64.jar:$HOME/.m2/repository/org/openjfx/javafx-base/17.0.1/javafx-base-17.0.1-mac-aarch64.jar:$HOME/.m2/repository/org/openjfx/javafx-controls/17.0.1/javafx-controls-17.0.1-mac-aarch64.jar" -m com.cs105.project/com.cs105.project.MainApplication

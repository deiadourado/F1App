package org.example.f1app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    DatabaseConnector dbConnector = new DatabaseConnector();
    //TableView<Student> tableView = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("studentView.fxml"));
        primaryStage.setScene(new Scene(root, 493, 507));
        primaryStage.show();
    }
}
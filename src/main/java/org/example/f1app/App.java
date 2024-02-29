package org.example.f1app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent root = loader.load();

            // Get the controller from the FXML file
            MainController controller = loader.getController();

            // Create a new scene
            Scene scene = new Scene(root);

            // Load the CSS file
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

            // Set the scene to the stage
            stage.setScene(scene);
            stage.setTitle("F1 Best Drivers Application");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
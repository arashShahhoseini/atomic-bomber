package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Plane;

import java.io.IOException;
import java.util.Objects;

public class HelloMenu extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        HelloMenu.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloMenu.class.getResource("/FXML/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.setTitle("Atomic Bomber");
        stage.setScene(scene);
        stage.centerOnScreen();

        Image icon = new Image((Objects.requireNonNull(Plane.class.getResource("/images/Helicopter.png")).toExternalForm()));
        stage.getIcons().add(icon);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
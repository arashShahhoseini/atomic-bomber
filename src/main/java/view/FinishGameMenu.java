package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FinishGameMenu extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloMenu.class.getResource("/FXML/finish.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Atomic Bomber");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}

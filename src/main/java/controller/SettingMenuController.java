package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import model.Game;
import view.ControlMenu;
import view.HelloMenu;
import view.MainMenu;

import java.io.IOException;

public class SettingMenuController {

    public void back() {
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void audio() {

    }

    public void blakWhite(MouseEvent mouseEvent) {
    }

    public void control(MouseEvent mouseEvent) {

        ControlMenu controlMenu = new ControlMenu();
        try {
            controlMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void easy(MouseEvent mouseEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("EASY MODE:)");
        alert.setContentText("Choose this if you are noobe sag");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Game.setGameMode("easy");
            }
        });
    }

    public void medium(MouseEvent mouseEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("MEDIUM MODE");
        alert.setContentText("Choose this if you want test your self");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Game.setGameMode("medium");
            }
        });
    }

    public void hard(MouseEvent mouseEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("HARD MODE!!!");
        alert.setContentText("Choose this if you want a real challenge");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Game.setGameMode("hard");
            }
        });
    }

    public void unmute(MouseEvent mouseEvent) {

        Game game = Game.getGameData();
        game.getMediaPlayer().play();
    }

    public void mute(MouseEvent mouseEvent) {

        Game game = Game.getGameData();
        game.getMediaPlayer().stop();
    }
}

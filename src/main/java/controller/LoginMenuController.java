package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Player;
import view.HelloMenu;
import view.MainMenu;

import java.io.IOException;

public class LoginMenuController {

    @FXML
    public TextField username;
    @FXML
    public TextField password;

    public void logIn() {

        String playerUsername = username.getText();
        String playerPassword = password.getText();
        Player player = Player.getPlayer(playerUsername, playerPassword);

        if (player == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong Data");
            alert.setHeaderText("Please check your username or password");
            alert.showAndWait();
            return;
        }

        Player.setLoggedInPlayer(player);
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signUp() {
        System.out.println(username.getText());
        HelloMenu helloMenu = new HelloMenu();
        try {
            helloMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
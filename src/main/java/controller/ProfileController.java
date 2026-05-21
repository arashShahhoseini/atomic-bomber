package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Player;
import view.AvatarMenu;
import view.HelloMenu;
import view.MainMenu;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private void initialize() {
        setInitialUsername();
        setInitialPassword();
    }

    private void setInitialPassword() {
        String password = Player.getLoggedInPlayer().getPassword();
        passwordField.setText(password);
    }

    private void setInitialUsername() {
        String username = Player.getLoggedInPlayer().getUsername();
        usernameField.setText(username);
    }

    public void back(MouseEvent mouseEvent) {

        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(MouseEvent mouseEvent) {

        Player player = Player.getLoggedInPlayer();
        player.deleteAccount();
        HelloMenu helloMenu = new HelloMenu();
        try {
            helloMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public void logOut(MouseEvent mouseEvent) {

        HelloMenu helloMenu = new HelloMenu();
        try {
            helloMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveUsername(MouseEvent mouseEvent) {

        ArrayList<Player> players = Player.getPlayers();
        for (Player player: players) {
            if (usernameField.getText().equals(player.getUsername())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Username already exist!");
                alert.setHeaderText("Please change your username.");
                alert.setContentText("""
                                yor username is already used.
                                """);
                alert.showAndWait();
                return;
            }
        }
        Player.getLoggedInPlayer().setUsername(usernameField.getText());
    }

    public void savePassword(MouseEvent mouseEvent) {

        Player.getLoggedInPlayer().setPassword(passwordField.getText());
    }

    public void avatar(MouseEvent mouseEvent) {

        AvatarMenu avatarMenu = new AvatarMenu();
        try {
            avatarMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

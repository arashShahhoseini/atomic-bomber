package controller;

import view.HelloMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Player;
import regexes.SignUpRegex;
import view.LoginMenu;
import view.MainMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField rePassword;

    public void signUp() {
        Matcher matcher;
        ArrayList<Player> players = Player.getPlayers();

        for (Player player : players) {
            if (Objects.equals(player.getUsername(), username.getText())) {
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
        if (!(getCommandMatcher(username.getText(), SignUpRegex.username.getRegex())).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Username");
            alert.setHeaderText("Please check your username:");
            alert.setContentText("""
                                Your username should:
                                - Be between 4 to 20 characters
                                - Contain only English letters, numbers, or the (_) character
                                """);
            alert.showAndWait();
            return;
        }
        else if (!(getCommandMatcher(password.getText(), SignUpRegex.password.getRegex())).matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Weak Password!");
            alert.setHeaderText("Please check your password:");
            alert.setContentText("""
                                Your password should:
                                - Be 6 characters or more
                                - Not have space character
                                """);
            alert.showAndWait();
            return;
        }
        else if (!password.getText().equals(rePassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Wrong Re-Enter Password!");
            alert.setHeaderText("Please check your re-enter password:");
            alert.setContentText("""
                                Your re-enter password doesnt match with password
                                """);
            alert.showAndWait();
            return;
        }
        Player player = new Player(username.getText(), password.getText());
        Player.setLoggedInPlayer(player);
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login() {
        LoginMenu loginMenu = new LoginMenu();
        try {
            loginMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void skip() {
        Player player = new Player("guest", null);
        Player.setLoggedInPlayer(player);
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Matcher getCommandMatcher(String input, String regex) {
        return Pattern.compile(regex).matcher(input);
    }

}
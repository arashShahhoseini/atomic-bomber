package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Plane;
import model.Player;
import view.*;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {

    @FXML
    private ImageView image;

    @FXML
    private Button profile;

    @FXML
    private void initialize() {
        setInitialUsername();
        setInitialAvatar();
    }

    private void setInitialUsername() {
        String username = Player.getLoggedInPlayer().getUsername();
        profile.setText(username);
    }

    private void setInitialAvatar() {

        Image playerImage = Player.getLoggedInPlayer().getImage();
        if (playerImage == null)
            setRandomImage();
        else image.setImage(playerImage);
    }

    public void setRandomImage() {
        int randomNumber = (int) (Math.random() * 8) + 1;
        Image randomImage = new Image(Objects.requireNonNull(Plane.class.getResource("/images/" + randomNumber + ".png")).toExternalForm());
        image.setImage(randomImage);

        Player.getLoggedInPlayer().setImage(randomImage);
    }

    public void newGame() {
        GameLauncher gameLauncher = new GameLauncher(profile.getText());
        try {
            gameLauncher.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setting() {
        SettingMenu settingMenu = new SettingMenu();
        try {
            settingMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void profile() {

        ProfileMenu profileMenu = new ProfileMenu();
        try {
            profileMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leaderBoard() {

        LeaderBoardMenu leaderBoardMenu = new LeaderBoardMenu();
        try {
            leaderBoardMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void avatar() {

        AvatarMenu avatarMenu = new AvatarMenu();
        try {
            avatarMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        Platform.exit();
    }


}

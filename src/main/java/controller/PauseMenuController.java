package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import model.Game;
import model.Player;
import view.HelloMenu;
import view.MainMenu;
import view.animation.Sound;

import java.io.IOException;

public class PauseMenuController {

    @FXML
    private Button up;
    @FXML
    private Button left;
    @FXML
    private Button right;
    @FXML
    private Button down;
    @FXML
    private void initialize() {
        Player player = Player.getLoggedInPlayer();
        setButton(player);
    }

    private void setButton(Player player) {

        up.setText(player.getMoveUp().getName());
        down.setText(player.getMoveDown().getName());
        right.setText(player.getMoveRight().getName());
        left.setText(player.getMoveLeft().getName());
    }

    public void exit(MouseEvent mouseEvent) {

        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(MouseEvent mouseEvent) {

    }

    public void music2(MouseEvent mouseEvent) {

        Game game = Game.getGameData();
        game.getMediaPlayer().stop();
        game.setMediaPlayer(new MediaPlayer(Sound.MUSIC2.getMedia()));
        game.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
        game.getMediaPlayer().play();
    }

    public void music1(MouseEvent mouseEvent) {

        Game game = Game.getGameData();
        game.getMediaPlayer().stop();
        game.setMediaPlayer(new MediaPlayer(Sound.MUSIC1.getMedia()));
        game.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
        game.getMediaPlayer().play();
    }

    public void music3(MouseEvent mouseEvent) {

        Game game = Game.getGameData();
        game.getMediaPlayer().stop();
        game.setMediaPlayer(new MediaPlayer(Sound.MUSIC3.getMedia()));
        game.getMediaPlayer().setCycleCount(MediaPlayer.INDEFINITE);
        game.getMediaPlayer().play();
    }

    public void mute(MouseEvent mouseEvent) {

        Game game = Game.getGameData();
        game.getMediaPlayer().stop();
    }
}

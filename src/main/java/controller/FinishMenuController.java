package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Game;
import model.Player;
import view.HelloMenu;
import view.MainMenu;

import java.io.IOException;

public class FinishMenuController {

    @FXML
    private Button accuracy;
    @FXML
    private Button kills;
    @FXML
    private Button wave;
    @FXML
    private Label status;
    @FXML
    private void initialize() {
        setStatues();
    }

    private void setStatues() {

        Game game = Game.getGameData();
        game.getMediaPlayer().stop();
        game.setAccuracy((double) game.getSuccessfulShoot() / game.getAllShoots() * 100);


        printScores(game);
        setScores(game);
    }

    private void printScores(Game game) {

        int mode = 0;
        if (Game.getGameMode().equals("hard")) mode = 3;
        if (Game.getGameMode().equals("medium")) mode = 2;
        if (Game.getGameMode().equals("easy")) mode = 1;
        game.setKillsInMode((game.getKills() * mode));

        status.setText("winner");
        if (game.getLastWave() - 1 != 3)
            status.setText("loser");
        wave.setText("last wave: " + game.getLastWave());
        if (game.getLastWave() == 4)
            wave.setText("last wave: " + "3");
        kills.setText("kills: " + game.getKills());
        accuracy.setText("accuracy: " + (int) game.getAccuracy() + "%");
    }

    private void setScores(Game game) {

        Player player = Player.getLoggedInPlayer();
        player.setScore(player.getScore() + game.getScore());
        player.setKills(player.getKills() + game.getKills());
        player.setKillsInMode(game.getKillsInMode() + player.getKillsInMode());
        player.setAllShoots(player.getAllShoots() + game.getAllShoots());
        player.setSuccessfulShoot(player.getSuccessfulShoot() + game.getSuccessfulShoot());
        System.out.println(player.getAllShoots());
        System.out.println(player.getSuccessfulShoot());
        player.setAccuracy((double) player.getSuccessfulShoot() / player.getAllShoots() * 100);
    }

    public void back() {


        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

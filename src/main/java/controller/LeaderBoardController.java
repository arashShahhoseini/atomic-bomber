package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.Player;
import view.HelloMenu;
import view.MainMenu;

import java.io.IOException;
import java.util.ArrayList;

public class LeaderBoardController {

    @FXML
    private Button first;
    @FXML
    private Button second;
    @FXML
    private Button third;
    @FXML
    private Button forth;
    @FXML
    private Button fifth;
    @FXML
    private Button sixth;
    @FXML
    private Button seventh;
    @FXML
    private Button eighth;
    @FXML
    private Button ninth;
    @FXML
    private Button tenth;
    @FXML
    private void initialize() {
        setLeaderBoard();
    }

    private void setLeaderBoard() {

        ArrayList<Player> players = sortByScores();

        int i = 0;
        for (Player player:
             players) {
            if (i == 0)
                first.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            else if (i == 1)
                second.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            else if (i == 2)
                third.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            else if (i == 3)
                forth.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            else if (i == 4)
                fifth.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            else if (i == 5)
                sixth.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            else if (i == 6)
                seventh.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            else if (i == 7)
                eighth.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            else if (i == 8)
                ninth.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            else if (i == 9)
                tenth.setText(i + 1 + "." + player.getUsername() + " : " + player.getScore());
            i ++;
        }
    }

    public void kill(MouseEvent mouseEvent) {

        ArrayList<Player> players = sortByKills();

        int i = 0;
        for (Player player:
                players) {
            if (i == 0)
                first.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            else if (i == 1)
                second.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            else if (i == 2)
                third.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            else if (i == 3)
                forth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            else if (i == 4)
                fifth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            else if (i == 5)
                sixth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            else if (i == 6)
                seventh.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            else if (i == 7)
                eighth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            else if (i == 8)
                ninth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            else if (i == 9)
                tenth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKills());
            i ++;
        }
    }

    public void Mode(MouseEvent mouseEvent) {

        ArrayList<Player> players = sortByKillsInMode();

        int i = 0;
        for (Player player:
                players) {
            if (i == 0)
                first.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            else if (i == 1)
                second.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            else if (i == 2)
                third.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            else if (i == 3)
                forth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            else if (i == 4)
                fifth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            else if (i == 5)
                sixth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            else if (i == 6)
                seventh.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            else if (i == 7)
                eighth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            else if (i == 8)
                ninth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            else if (i == 9)
                tenth.setText(i + 1 + "." + player.getUsername() + " : " + player.getKillsInMode());
            i ++;
        }
    }

    public void accuracy(MouseEvent mouseEvent) {

        ArrayList<Player> players = sortByAccuracy();

        int i = 0;
        for (Player player:
                players) {
            if (i == 0)
                first.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            else if (i == 1)
                second.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            else if (i == 2)
                third.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            else if (i == 3)
                forth.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            else if (i == 4)
                fifth.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            else if (i == 5)
                sixth.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            else if (i == 6)
                seventh.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            else if (i == 7)
                eighth.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            else if (i == 8)
                ninth.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            else if (i == 9)
                tenth.setText(i + 1 + "." + player.getUsername() + " : " + (int) player.getAccuracy());
            i ++;
        }
    }

    private ArrayList<Player> sortByKillsInMode() {

        ArrayList<Player> players = Player.getPlayers();

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {

                if (players.get(j).getKillsInMode() > players.get(i).getKillsInMode()) {

                    Player temp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, temp);
                }
            }
        }

        return players;

    }

    private ArrayList<Player> sortByKills() {

        ArrayList<Player> players = Player.getPlayers();

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {

                if (players.get(j).getKills() > players.get(i).getKills()) {

                    Player temp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, temp);
                }
            }
        }

        return players;
    }

    private ArrayList<Player> sortByScores() {

        ArrayList<Player> players = Player.getPlayers();

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {

                if (players.get(j).getScore() > players.get(i).getScore()) {

                    Player temp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, temp);
                }
            }
        }

        return players;
    }

    private ArrayList<Player> sortByAccuracy() {

        ArrayList<Player> players = Player.getPlayers();

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {

                if (players.get(j).getAccuracy() > players.get(i).getAccuracy()) {

                    Player temp = players.get(i);
                    players.set(i, players.get(j));
                    players.set(j, temp);
                }
            }
        }

        return players;
    }

    public void back(MouseEvent mouseEvent) {

        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

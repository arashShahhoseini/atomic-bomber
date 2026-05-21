package model;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class Player {

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
    private static Player loggedInPlayer;
    private Image image;
    private int allShoots = 0;
    private int successfulShoot = 0;
    private double accuracy = 0;
    private int killsInMode = 0;
    private int kills = 0;
    private KeyCode MoveRight = KeyCode.D;
    private KeyCode MoveLeft = KeyCode.A;
    private KeyCode MoveUp = KeyCode.W;
    private KeyCode MoveDown = KeyCode.S;
    private int score;
    private static final ArrayList<Player> players = new ArrayList<>();

    public Player(String username, String password) {
        this.password = password;
        this.username = username;
        if (!username.equals("guest"))
            players.add(this);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static Player getLoggedInPlayer() {
        return loggedInPlayer;
    }

    public static void setLoggedInPlayer(Player player) {
        loggedInPlayer = player;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static Player getPlayer(String username, String password) {

        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                if (player.getPassword().equals(password))
                    return player;
            }
        }
        return null;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }


    public KeyCode getMoveRight() {
        return MoveRight;
    }

    public void setMoveRight(KeyCode moveRight) {
        MoveRight = moveRight;
    }

    public KeyCode getMoveLeft() {
        return MoveLeft;
    }

    public void setMoveLeft(KeyCode moveLeft) {
        MoveLeft = moveLeft;
    }

    public KeyCode getMoveUp() {
        return MoveUp;
    }

    public void setMoveUp(KeyCode moveUp) {
        MoveUp = moveUp;
    }

    public KeyCode getMoveDown() {
        return MoveDown;
    }

    public void setMoveDown(KeyCode moveDown) {
        MoveDown = moveDown;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void deleteAccount() {

        players.remove(this);
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getKills() {
        return kills;
    }

    public int getKillsInMode() {
        return killsInMode;
    }

    public void setKillsInMode(int killsInMode) {
        this.killsInMode = killsInMode;
    }

    public int getAllShoots() {
        return allShoots;
    }

    public void setAllShoots(int allShoots) {
        this.allShoots = allShoots;
    }

    public int getSuccessfulShoot() {
        return successfulShoot;
    }

    public void setSuccessfulShoot(int successfulShoot) {
        this.successfulShoot = successfulShoot;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}

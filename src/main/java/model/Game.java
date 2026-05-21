package model;

import javafx.scene.Group;
import javafx.scene.media.MediaPlayer;
import view.animation.Sound;

public class Game {
    private MediaPlayer mediaPlayer = new MediaPlayer(Sound.MUSIC1.getMedia());
    private boolean stopGame = false;
    private String username;
    private int lastWave;
    private int score = 0;
    private int kills = 0;
    private int allShoots = 0;
    private int successfulShoot = 0;
    private int freezeNumber = 0;
    private boolean canFreeze = false;
    private boolean migFreeze = false;
    private double accuracy = 0;
    private int killsInMode = 0;
    private final Group trees = new Group();
    private final Group buildings = new Group();
    private final Group trucks = new Group();
    private final Group tanks = new Group();
    private final Group migs = new Group();
    private final Group tankBombs = new Group();
    private final Group bases = new Group();
    private static Game gameData;
    private static String GameMode = "easy";

    public Game (String username){

        this.username = username;
        gameData = this;
    }

    public double getWIDTH() {
        return 1080;
    }

    public double getHEIGHT() {
        return 720;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Group getTrees() {
        return trees;
    }

    public Group getBuildings() {
        return buildings;
    }

    public Group getTrucks() {
        return trucks;
    }

    public Group getTanks() {
        return tanks;
    }

    public Group getTankBombs() {
        return tankBombs;
    }

    public static String getGameMode() {
        return GameMode;
    }

    public static void setGameMode(String gameMode) {
        GameMode = gameMode;
    }

    public Group getMigs() {
        return migs;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getKillsInMode() {
        return killsInMode;
    }

    public void setKillsInMode(int killsInMode) {
        this.killsInMode = killsInMode;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
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

    public static Game getGameData() {

        return gameData;
    }

    public int getLastWave() {
        return lastWave;
    }

    public void setLastWave(int lastWave) {
        this.lastWave = lastWave;
    }

    public boolean isStopGame() {
        return stopGame;
    }

    public void setStopGame(boolean stopGame) {
        this.stopGame = stopGame;
    }

    public int getFreezeNumber() {
        return freezeNumber;
    }

    public void setFreezeNumber(int freezeNumber) {
        this.freezeNumber = freezeNumber;
    }

    public boolean isCanFreeze() {
        return canFreeze;
    }

    public void setCanFreeze(boolean canFreeze) {
        this.canFreeze = canFreeze;
    }

    public boolean isMigFreeze() {
        return migFreeze;
    }

    public void setMigFreeze(boolean migFreeze) {
        this.migFreeze = migFreeze;
    }

    public Group getBases() {
        return bases;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
}

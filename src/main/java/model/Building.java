package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Objects;

public class Building extends Rectangle {

    private double WIDTH;
    private double HEIGHT;
    private final int score = 25;
    private boolean isHit = false;
    private final Game game;
    private static final ArrayList<Building> buildings = new ArrayList<>();

    public Building(Game game) {
        super(141, 94);
        setWIDTH(141);
        setHEIGHT(94);
        this.game = game;
        double randomX = (double) (Math.random() * (game.getWIDTH() - WIDTH - 5)) + 5;
        setX(randomX);
        buildings.add(this);
        setY(game.getHEIGHT() - HEIGHT - 103);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/building.png")).toExternalForm())));
    }

    public static void remove(Building building) {

        buildings.remove(building);
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public void setWIDTH(double WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setHEIGHT(double HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public Game getGame() {
        return game;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public int getScore() {
        return score;
    }

    public static ArrayList<Building> getBuildings() {
        return buildings;
    }
}

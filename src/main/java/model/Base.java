package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Objects;

public class Base extends Rectangle {

    private double WIDTH;
    private double HEIGHT;
    private final int score = 30;
    private boolean isHit = false;
    private final Game game;
    private static final ArrayList<Base> bases = new ArrayList<>();

    public Base(Game game) {
        super(94, 94);
        setWIDTH(141);
        setHEIGHT(94);
        this.game = game;
        double randomX = (double) (Math.random() * (game.getWIDTH() - WIDTH - 5)) + 5;
        setX(randomX);
        setY(game.getHEIGHT() - HEIGHT - 100);
        bases.add(this);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/shelter.png")).toExternalForm())));
    }

    public static ArrayList<Base> getBases() {
        return bases;
    }

    public static void remove(Base base) {

        bases.remove(base);
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
}

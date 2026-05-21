package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Tree extends Rectangle {

    private double WIDTH;
    private double HEIGHT;
    private boolean isHit = false;
    private final Game game;

    public Tree(Game game) {
        super(40, 80);
        setWIDTH(40);
        setHEIGHT(80);
        this.game = game;
        double randomX = (double) (Math.random() * (game.getWIDTH() - WIDTH - 5)) + 5;
        setX(randomX);
        setY(game.getHEIGHT() - HEIGHT - 85);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/tree.png")).toExternalForm())));
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
}

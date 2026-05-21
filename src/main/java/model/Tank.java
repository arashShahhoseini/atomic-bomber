package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animation.TankAnimation;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Tank extends Rectangle {

    private double WIDTH;
    private double HEIGHT;
    private final int score = 75;
    private Game game;
    private int radius = 300;
    private TankAnimation tankAnimation;
    private boolean isHit;
    private static final ArrayList<Tank> tanks = new ArrayList<>();

    public Tank (double x, double y, Game game) {

        super (x , y, 114, 50);
        setHEIGHT(y);
        setWIDTH(x);
        int[] numbers = {-100, -500, 1100, 1500, -300, 1300};
        int randomIndex = new Random().nextInt(numbers.length);
        int randomNumber = numbers[randomIndex];
        setX(randomNumber);
        setY(game.getHEIGHT() - 55);
        tanks.add(this);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/tankRight.png")).toExternalForm())));
        if (getX() > 1000) setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/tankLeft.png")).toExternalForm())));
    }

    public static void remove(Tank tank) {
        tanks.remove(tank);
    }

    public TankAnimation getTankAnimation() {
        return tankAnimation;
    }

    public void setTankAnimation(TankAnimation tankAnimation) {
        this.tankAnimation = tankAnimation;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(double HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(double WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public int getScore() {
        return score;
    }

    public static ArrayList<Tank> getTanks() {
        return tanks;
    }
}

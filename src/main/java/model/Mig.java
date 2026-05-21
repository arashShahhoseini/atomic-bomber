package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animation.MigAnimation;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Mig extends Rectangle {

    private double WIDTH;
    private double HEIGHT;
    private Game game;
    private int radius = 300;
    private MigAnimation migAnimation;
    private static ArrayList<Mig> migs = new ArrayList<>();

    public Mig (double x, double y, Game game) {

        super (x , y, 99, 34);
        setHEIGHT(y);
        setWIDTH(x);

        int[] numbersX = {-1000, -500, 1400, 2000, -700, 1700};
        int randomIndexX = new Random().nextInt(numbersX.length);
        int randomNumberX = numbersX[randomIndexX];
        int[] numbersY = {200, 300, 350, 150, 100, 250};
        int randomIndexY = new Random().nextInt(numbersY.length);
        int randomNumberY = numbersY[randomIndexY];

        setX(randomNumberX);
        setY(randomNumberY);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/migRight.png")).toExternalForm())));
        if (getX() > 1000) setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/migLeft.png")).toExternalForm())));
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

    public MigAnimation getMigAnimation() {
        return migAnimation;
    }

    public void setMigAnimation(MigAnimation migAnimation) {
        this.migAnimation = migAnimation;
    }

    public static ArrayList<Mig> getMigs() {
        return migs;
    }

    public static void setMigs(ArrayList<Mig> migs) {
        Mig.migs = migs;
    }
}

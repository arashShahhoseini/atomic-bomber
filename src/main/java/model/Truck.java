package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animation.ShootingAnimation;
import view.animation.TruckAnimation;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Truck extends Rectangle {

    private double WIDTH;
    private double HEIGHT;
    private final int score = 50;
    private Game game;
    private TruckAnimation truckAnimation;
    private boolean isHit;
    private static final ArrayList<Truck> trucks = new ArrayList<>();

    public Truck (double x, double y, Game game) {

        super (x , y, 86, 47);
        int[] numbers = {-100, -500, 1100, 1500, -300, 1300};
        int randomIndex = new Random().nextInt(numbers.length);
        int randomNumber = numbers[randomIndex];
        setX(randomNumber);
        setY(game.getHEIGHT() - 100);
        trucks.add(this);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/truckLeft.png")).toExternalForm())));
        if (getX() < 0) setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/truckRight.png")).toExternalForm())));

    }

    public static void remove(Truck truck) {
        trucks.remove(truck);
    }

    public int getScore() {
        return score;
    }

    public TruckAnimation getTruckAnimation() {
        return truckAnimation;
    }

    public void setTruckAnimation(TruckAnimation truckAnimation) {
        this.truckAnimation = truckAnimation;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public static ArrayList<Truck> getTrucks() {
        return trucks;
    }

}

package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.animation.PlaneAnimation;
import view.animation.PlaneExplosionAnimation;

import java.util.Objects;

public class Plane extends Rectangle {

    private double WIDTH;
    private double HEIGHT;
    private int AtomicBombNumber = 0;
    private int clusterNumber = 0;
    private int HP = 4;
    private final Game game;
    private PlaneAnimation planeAnimation;
    private PlaneExplosionAnimation planeExplosionAnimation;

    public Plane(Game game) {
        super(99, 34);
        setWIDTH(34);
        setHEIGHT(99);
        this.game = game;
        setX((game.getWIDTH() - WIDTH)/2);
        setY((game.getHEIGHT() - HEIGHT)/2 - 200);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/planeL.png")).toExternalForm())));
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

    public PlaneAnimation getPlaneAnimation() {
        return planeAnimation;
    }

    public void setPlaneAnimation(PlaneAnimation planeAnimation) {
        this.planeAnimation = planeAnimation;
    }

    public PlaneExplosionAnimation getPlaneExplosionAnimation() {
        return planeExplosionAnimation;
    }

    public void setPlaneExplosionAnimation(PlaneExplosionAnimation planeExplosionAnimation) {
        this.planeExplosionAnimation = planeExplosionAnimation;
    }

    public int getAtomicBombNumber() {
        return AtomicBombNumber;
    }

    public void setAtomicBombNumber(int atomicBombNumber) {
        AtomicBombNumber = atomicBombNumber;
    }

    public int getClusterNumber() {
        return clusterNumber;
    }

    public void setClusterNumber(int clusterNumber) {
        this.clusterNumber = clusterNumber;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}

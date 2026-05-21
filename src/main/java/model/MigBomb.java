package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class MigBomb extends Rectangle {
    private double WIDTH;
    private double HEIGHT;

    public MigBomb(Mig mig) {
        super(20, 20);
        setHEIGHT(20);
        setWIDTH(20);
        setY(mig.getY());
        setX(mig.getX() + 40);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/migBomb.png")).toExternalForm())));
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(double WIDTH) {
        this.WIDTH = WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(double HEIGHT) {
        this.HEIGHT = HEIGHT;
    }
}

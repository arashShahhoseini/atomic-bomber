package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class TankBomb extends Rectangle {
    private double WIDTH;
    private double HEIGHT;

    public TankBomb(Tank tank) {
        super(20, 20);
        setHEIGHT(20);
        setWIDTH(20);
        setY(tank.getY());
        setX(tank.getX() + 40);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/tankBomb.png")).toExternalForm())));
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

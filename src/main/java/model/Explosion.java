package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class Explosion extends Rectangle {

    public Explosion (Bombs bombs) {
        super(61, 92);
        this.setX(bombs.getX() - 10);
        this.setY(bombs.getY() - 60);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/bombExplosion1.png")).toExternalForm())));

    }
}

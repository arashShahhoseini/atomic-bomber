package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class AtomExplosion extends Rectangle {

    public AtomExplosion (Bombs bombs) {
        super(200, 160);
        this.setX(bombs.getX() - 75);
        this.setY(560);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/AtomExplosion1.png")).toExternalForm())));

    }
}

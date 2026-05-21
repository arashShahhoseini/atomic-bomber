package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class AtomBubble extends Rectangle {

    public AtomBubble(Base base) {

        super(50, 50);
        setX(base.getX());
        setY(base.getY());
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/atomBubble.png")).toExternalForm())));
    }
}

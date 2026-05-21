package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class MigDanger extends Rectangle {

    public MigDanger () {

        super(100, 100);
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/danger.png")).toExternalForm())));
        setX(490);
        setY(310);
    }
}

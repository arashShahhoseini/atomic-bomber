package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.Objects;

public class Rocket extends Bombs{

    public Rocket(Plane plane) {

        super(20, 28, plane, "R");

        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/rocket.png")).toExternalForm())));
    }

}

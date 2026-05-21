package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.Objects;

public class Cluster extends Bombs{

    public Cluster(Plane plane) {

        super(20, 39, plane, "C");
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/khooshe.png")).toExternalForm())));
    }

}
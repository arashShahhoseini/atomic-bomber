package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class ClusterBubble extends Rectangle {

    public ClusterBubble(Building building) {

        super(50, 50);
        setX(building.getX());
        setY(building.getY());
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/clusterBubble.png")).toExternalForm())));
    }
}

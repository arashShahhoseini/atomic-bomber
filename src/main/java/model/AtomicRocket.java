package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.Objects;

public class AtomicRocket extends Bombs{

    public AtomicRocket(Plane plane) {

        super(20, 42, plane, "A");
        setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/Atomic Bomb.png")).toExternalForm())));
    }
}

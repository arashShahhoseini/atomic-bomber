package view.animation;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Plane;

import java.util.Objects;

public class PlaneAnimation extends Transition {

    private final Plane plane;
    private int speed = -3;

    public PlaneAnimation(Plane plane) {
        this.plane = plane;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(100));
    }

    @Override
    protected void interpolate(double v) {

        double x = plane.getX() + speed;
        if (speed > 0) {
            plane.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/planeR.png")).toExternalForm())));
        }
        else if (speed < 0)
            plane.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/planeL.png")).toExternalForm())));

        plane.setX(x);
        if (plane.getX() >= 1080 - plane.getWIDTH() / 2) {
            plane.setX(0 - plane.getWIDTH() / 2 - 40);
        }
        else if (plane.getX() <= 0 - plane.getWIDTH()/2 - 40) {
            plane.setX(1080 - plane.getWIDTH() / 2);
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

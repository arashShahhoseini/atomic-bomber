package view.animation;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Game;
import model.Plane;
import model.Truck;

import java.util.Objects;

public class TruckAnimation extends Transition {

    private Pane pane;
    private Game game;
    private Truck truck;
    private double speed = 1.5;

    public TruckAnimation (Pane pane, Game game, Truck truck) {
        this.game = game;
        this.pane = pane;
        this.truck = truck;
        setCycleCount(-1);
        int duration = 1000;
        setCycleDuration(Duration.millis(duration));
    }



    @Override
    protected void interpolate(double v) {

        double x = truck.getX() - speed;

        if (x < 0 && speed > 0) {
            truck.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/truckRight.png")).toExternalForm())));
            speed = -speed;
//            game.getTrucks().getChildren().remove(truck);
//            pane.getChildren().remove(truck);
//            this.stop();
        } else if (x > 1000 && speed < 0) {
            truck.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/truckLeft.png")).toExternalForm())));
            speed = -speed;
        }

            truck.setX(x);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}

package view.animation;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.ClusterExplosion;
import model.Explosion;
import model.Plane;

import java.util.Objects;

public class ClusterExplosionAnimation extends Transition {

    private final Pane pane;
    private final ClusterExplosion clusterExplosion;

    public ClusterExplosionAnimation(ClusterExplosion clusterExplosion, Pane pane) {
        this.pane = pane;
        this.clusterExplosion = clusterExplosion;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(500)); // Decrease the duration to 1 second
        this.setInterpolator(Interpolator.EASE_OUT); // Use an ease-out interpolator for a smoother animation
    }

    @Override
    protected void interpolate(double v) {
        int number = 0;
        if (v < 0.25) number = 1;
        else if (v < 0.5) number = 2;
        else if (v < 0.75) number = 3;
        else number = 4;

        // Set the explosion image
        clusterExplosion.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/ClusterExplosion" + number + ".png")).toExternalForm())));

        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(clusterExplosion);
            }
        });
    }
}

package view.animation;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Bombs;
import model.Explosion;
import model.Plane;

import java.util.Objects;

public class BombExplosion extends Transition {

    private final Pane pane;
    private final Explosion explosion;

    public BombExplosion(Explosion explosion, Pane pane) {
        this.pane = pane;
        this.explosion = explosion;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(500));
        this.setInterpolator(Interpolator.EASE_OUT);

    }

    @Override
    protected void interpolate(double v) {
        int number = 0;
        if (v < 0.25) number = 1;
        else if (v < 0.5) number = 2;
        else if (v < 0.75) number = 3;
        else number = 4;

        explosion.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/bombExplosion" + number + ".png")).toExternalForm())));

        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(explosion);
            }
        });
    }
}

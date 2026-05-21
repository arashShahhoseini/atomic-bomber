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
import model.AtomExplosion;
import model.Bombs;
import model.Explosion;
import model.Plane;

import java.util.Objects;

public class AtomExplosionAnimation extends Transition {

    private final Pane pane;
    private final AtomExplosion atomExplosion;

    public AtomExplosionAnimation(AtomExplosion atomExplosion, Pane pane) {
        this.pane = pane;
        this.atomExplosion = atomExplosion;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(1000));
        this.setInterpolator(Interpolator.EASE_OUT);
     }

    @Override
    protected void interpolate(double v) {
        int number = 0;
        if (v < 0.20) number = 1;
        else if (v < 0.40) number = 2;
        else if (v < 0.60) number = 3;
        else if (v < 0.80) number = 4;
        else number = 5;

        atomExplosion.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/AtomExplosion" + number + ".png")).toExternalForm())));

        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(atomExplosion);
            }
        });
    }
}

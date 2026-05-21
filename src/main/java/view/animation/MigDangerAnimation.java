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
import model.MigDanger;
import model.Plane;

import java.util.Objects;

public class MigDangerAnimation extends Transition {

    private final Pane pane;
    private final MigDanger migDanger;

    public MigDangerAnimation(MigDanger migDanger, Pane pane) {
        this.pane = pane;
        this.migDanger = migDanger;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(300)); // Decrease the duration to 1 second

    }

    @Override
    protected void interpolate(double v) {
        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(migDanger);
            }
        });
    }
}

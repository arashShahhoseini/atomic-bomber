package view.animation;

import view.HelloMenu;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Plane;
import view.FinishGameMenu;

import java.io.IOException;
import java.util.Objects;

public class PlaneExplosionAnimation extends Transition {

    private final Pane pane;
    private final Plane plane;
    private boolean finishMenuStarted = false;

    public PlaneExplosionAnimation(Plane plane, Pane pane) {
        this.plane = plane;
        this.pane = pane;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(660));
    }


    @Override
    protected void interpolate(double v) {
        int number = 0;
        if (v >= 0 && v < 0.22) number = 1;
        else if (v > 0.22 && v < 0.44) number = 2;
        else number = 3;

        plane.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/planeExplosion" + number + ".png")).toExternalForm())));
        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.getChildren().remove(plane);
                finish();
            }
        });
    }

    private void finish() {
        if (!finishMenuStarted) {
            finishMenuStarted = true;
            FinishGameMenu finishGameMenu = new FinishGameMenu();
            try {
                finishGameMenu.start(HelloMenu.stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

package view.animation;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Game;
import model.Plane;
import model.Tank;

public class TankExplosionAnimation extends Transition {

    private final Pane pane;
    private final Tank tank;
    private final Group tanks;
    private final Game game;

    public TankExplosionAnimation(Tank tank, Pane pane, Group tanks, Game game) {
        this.tank = tank;
        this.tanks = tanks;
        this.pane = pane;
        this.game = game;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(660));
    }

    @Override
    protected void interpolate(double v) {
        int number = 0;
        if (v >= 0 && v < 0.166) number = 1;
        else if (v > 0.166 && v < 0.333) number = 2;
        else if (v > 0.333 && v < 0.5) number = 3;
        else if (v > 0.5) number = 4;

        tank.setFill(new ImagePattern(new Image((Plane.class.getResource("/images/tankExplosion" + number + ".png")).toExternalForm())));
        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tanks.getChildren().remove(tank);
                pane.getChildren().remove(tank);
                game.getTanks().getChildren().remove(tank);
            }
        });
    }
}

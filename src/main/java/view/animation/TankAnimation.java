package view.animation;

import controller.GameController;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Game;
import model.Plane;
import model.Tank;

import java.util.Objects;

public class TankAnimation extends Transition {

    private Pane pane;
    private Game game;
    private Tank tank;
    private long lastShootTime;
    private Plane plane;
    private double speed = 0.9;

    public TankAnimation (Pane pane, Game game, Tank tank, Plane plane) {
        this.game = game;
        this.pane = pane;
        this.tank = tank;
        this.plane = plane;
        setCycleCount(-1);
        int duration = 1000;
        setCycleDuration(Duration.millis(duration));
    }



    @Override
    protected void interpolate(double v) {

        double x = tank.getX() + speed;

        double X = plane.getX() - tank.getX();
        double Y = tank.getY() - plane.getY();
        double R = Math.sqrt((X * X) + (Y * Y));

        if (R < tank.getRadius()) {
            if (pane != null && !tank.isHit()) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastShootTime >= 5000) { // 5 second cooldown
                    GameController.tankShoot(this, tank, plane, game);
                    lastShootTime = currentTime;
                }
            } else {

                this.stop();
            }
        }

        if (tank.getX() > 1000 && speed > 0) {

            tank.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/tankLeft.png")).toExternalForm())));
            speed = -speed;
//            game.getTanks().getChildren().remove(tank);
//            pane.getChildren().remove(tank);
//            this.stop();
        } else if (tank.getX() < 0 && speed < 0) {

            tank.setFill(new ImagePattern(new Image(Objects.requireNonNull(Plane.class.getResource("/images/tankRight.png")).toExternalForm())));
            speed = -speed;
        }

        tank.setX(x);
    }


    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Pane getPane() {
        return pane;
    }
}

package view.animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.*;

public class TankShootingAnimation extends Transition {

    private final Game game;
    private final Pane pane;
    private final TankBomb tankBomb;
    private final Plane plane;
    private final Tank tank;
    private double speedX = 3;
    private double speedY = 3;
    private final double duration = 100;


    public TankShootingAnimation(Tank tank, Game game, TankBomb tankBomb, Pane pane, Plane plane) {
        this.game = game;
        this.tankBomb = tankBomb;
        this.plane = plane;
        this.tank = tank;
        this.pane = pane;
        this.setCycleDuration(Duration.millis(duration));
        this.setCycleCount(-1);
    }


    @Override
    protected void interpolate(double v) {

        double y = tankBomb.getY() - speedY;
        double x = tankBomb.getX() + speedX;

        double i = tankBomb.getX() - tank.getX();
        double j = tank.getY() - tankBomb.getY();
        double R = Math.sqrt((i * i) + (j * j));
        if (R > tank.getRadius()) {
            // Remove the TankBomb from the pane and stop the animation
            pane.getChildren().remove(tankBomb);
            this.stop();
            return;
        }

        if (tankBomb.getBoundsInParent().intersects(plane.getBoundsInParent()) && pane.getChildren().contains(plane)) {

            pane.getChildren().remove(tankBomb);
            game.getTankBombs().getChildren().remove(tankBomb);
            this.stop();
            plane.setHP(plane.getHP() - 1);
            if (plane.getHP() == 0) {
                PlaneExplosionAnimation planeExplosionAnimation = new PlaneExplosionAnimation(plane, pane);
                planeExplosionAnimation.play();
            }
        }

        tankBomb.setX(x);
        tankBomb.setY(y);
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
}

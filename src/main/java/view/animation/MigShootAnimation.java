package view.animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.*;

public class MigShootAnimation extends Transition {

    private final Game game;
    private final Pane pane;
    private final MigBomb migBomb;
    private final Plane plane;
    private final Mig mig;
    private double speedX = 3;
    private double speedY = 3;
    private final double duration = 100;

    public MigShootAnimation(Mig mig, Game game, MigBomb migBomb, Pane pane, Plane plane) {
        this.game = game;
        this.migBomb = migBomb;
        this.plane = plane;
        this.mig = mig;
        this.pane = pane;
        this.setCycleDuration(Duration.millis(duration));
        this.setCycleCount(-1);
    }


    @Override
    protected void interpolate(double v) {

        double y = migBomb.getY() + speedY;
        double x = migBomb.getX() + speedX;

        double i = migBomb.getX() - mig.getX();
        double j = mig.getY() - migBomb.getY();
        double R = Math.sqrt((i * i) + (j * j));

        if (R > mig.getRadius()) {
            // Remove the TankBomb from the pane and stop the animation
            pane.getChildren().remove(migBomb);
            this.stop();
            return;
        }

        if (migBomb.getBoundsInParent().intersects(plane.getBoundsInParent()) && pane.getChildren().contains(plane)) {

            pane.getChildren().remove(migBomb);
            this.stop();

            plane.setHP(plane.getHP() - 1);
            if (plane.getHP() == 0) {

                PlaneExplosionAnimation planeExplosionAnimation = new PlaneExplosionAnimation(plane, pane);
                planeExplosionAnimation.play();
            }

        }

        migBomb.setX(x);
        migBomb.setY(y);
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

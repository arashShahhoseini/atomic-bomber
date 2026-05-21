package view.animation;

import controller.GameController;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Game;
import model.Mig;
import model.MigDanger;
import model.Plane;

public class MigAnimation extends Transition {

    private Pane pane;
    private Game game;
    private Mig mig;
    private long lastShootTime;
    private Plane plane;
    private double speed = 1.7;

    public MigAnimation (Pane pane, Game game, Mig mig, Plane plane) {
        this.game = game;
        this.pane = pane;
        this.mig = mig;
        this.plane = plane;
        setCycleCount(-1);
        int duration = 1000;
        setCycleDuration(Duration.millis(duration));
    }



    @Override
    protected void interpolate(double v) {

        double x = mig.getX() + speed;

        double X = plane.getX() - mig.getX();
        double Y = mig.getY() - plane.getY();
        double R = Math.sqrt((X * X) + (Y * Y));

        if (R < mig.getRadius()) {
            if (pane != null) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastShootTime >= 5000) { // 5 second cooldown
                    GameController.migShoot(this, mig, plane, game);
                    lastShootTime = currentTime;
                }
            } else {

                this.stop();
            }
        }

        if (mig.getX() > 1100 && speed > 0) {

            game.getMigs().getChildren().remove(mig);
            pane.getChildren().remove(mig);
            this.stop();

        } else if (mig.getX() < -100 && speed < 0) {

            game.getMigs().getChildren().remove(mig);
            pane.getChildren().remove(mig);
            this.stop();
        }
        if (mig.getX() > -150 && mig.getX() < 100 && speed > 0) {

            MigDanger migDanger = new MigDanger();
            pane.getChildren().add(migDanger);
            MigDangerAnimation migDangerAnimation = new MigDangerAnimation(migDanger, pane);
            migDangerAnimation.play();
        }
        else if (mig.getX() > 1180 && mig.getX() < 1230 && speed < 0) {

            MigDanger migDanger = new MigDanger();
            pane.getChildren().add(migDanger);
            MigDangerAnimation migDangerAnimation = new MigDangerAnimation(migDanger, pane);
            migDangerAnimation.play();
        }

        if (mig.getBoundsInParent().intersects(plane.getBoundsInParent()) && pane.getChildren().contains(plane)) {

            pane.getChildren().remove(mig);

            this.stop();
            PlaneExplosionAnimation planeExplosionAnimation = new PlaneExplosionAnimation(plane, pane);
            planeExplosionAnimation.play();
        }

        mig.setX(x);
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

package view.animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.AtomBubble;
import model.Game;
import model.Plane;

public class AtomBubbleAnimation extends Transition {

    private AtomBubble atomBubble;
    private final Game game;
    private final Pane pane;
    private final Plane plane;

    public AtomBubbleAnimation(AtomBubble atomBubble, Game game, Pane pane, Plane plane) {

        this.atomBubble = atomBubble;
        this.game = game;
        this.pane = pane;
        this.plane = plane;
        double duration = 60;
        this.setCycleDuration(Duration.millis(duration));
        this.setCycleCount(-1);
    }
    @Override
    protected void interpolate(double v) {

        double y = atomBubble.getY() - 1;

        if (atomBubble.getY() < 100) {
            pane.getChildren().remove(atomBubble);
            this.stop();
        }
        if (atomBubble.getBoundsInParent().intersects(plane.getBoundsInParent()) && pane.getChildren().contains(atomBubble)) {

            pane.getChildren().remove(atomBubble);
            this.stop();
            plane.setAtomicBombNumber(plane.getAtomicBombNumber() + 1);
        }
        atomBubble.setY(y);
    }
}

package view.animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.ClusterBubble;
import model.Game;
import model.Plane;

public class ClusterBubbleAnimation extends Transition {

    private ClusterBubble clusterBubble;
    private final Game game;
    private final Pane pane;
    private final Plane plane;

    public ClusterBubbleAnimation(ClusterBubble clusterBubble, Game game, Pane pane, Plane plane) {

        this.clusterBubble = clusterBubble;
        this.game = game;
        this.pane = pane;
        this.plane = plane;
        double duration = 60;
        this.setCycleDuration(Duration.millis(duration));
        this.setCycleCount(-1);
    }
    @Override
    protected void interpolate(double v) {

        double y = clusterBubble.getY() - 1;

        if (clusterBubble.getY() < 100) {
            pane.getChildren().remove(clusterBubble);
            this.stop();
        }
        if (clusterBubble.getBoundsInParent().intersects(plane.getBoundsInParent()) && pane.getChildren().contains(clusterBubble)) {

            pane.getChildren().remove(clusterBubble);
            this.stop();
            plane.setClusterNumber(plane.getClusterNumber() + 1);
        }
        clusterBubble.setY(y);
    }
}

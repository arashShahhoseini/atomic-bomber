package view.animation;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Game;
import model.Plane;
import model.Tree;


public class TreeAnimation extends Transition {

    private final Pane pane;
    private final Tree tree;
    private final Game game;

    public TreeAnimation(Tree tree, Pane pane, Game game) {
        this.tree = tree;
        this.pane = pane;
        this.game = game;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(500));
    }

    @Override
    protected void interpolate(double v) {
        int number = 0;
        if (v >= 0 && v < 0.2) number = 1;
        else if (v > 0.2 && v < 0.4) number = 2;
        else number = 3;

        tree.setFill(new ImagePattern(new Image((Plane.class.getResource("/images/treeBurned" + number + ".png")).toExternalForm())));
        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.getTrees().getChildren().remove(tree);
            }
        });
    }
}

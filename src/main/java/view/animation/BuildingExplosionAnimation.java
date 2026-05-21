package view.animation;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Building;
import model.Plane;

import java.util.Objects;

public class BuildingExplosionAnimation extends Transition {

    private final Pane pane;
    private final Building building;
    private final Group buildings;

    public BuildingExplosionAnimation(Building building, Pane pane, Group buildings) {
        this.building = building;
        this.buildings = buildings;
        this.pane = pane;
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

        building.setFill(new ImagePattern(new Image((Plane.class.getResource("/images/buildingExplosion" + number + ".png")).toExternalForm())));
        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buildings.getChildren().remove(building);
            }
        });
    }
}

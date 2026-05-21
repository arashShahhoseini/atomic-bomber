package model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AccuracyBoard extends Rectangle {

    private final Game game;
    private final Text accuracyBoard;

    public AccuracyBoard(Game game, Pane pane) {
        super(100, 40);
        this.game = game;
        setY(1);
        setX(900);

        accuracyBoard = new Text();
        accuracyBoard.setFont(Font.font("Arial", 16));
        accuracyBoard.setTextAlignment(TextAlignment.CENTER);
        accuracyBoard.setX(getX() + getWidth() / 2);
        accuracyBoard.setY(getY() + getHeight() / 2 + 5); // Adjust the vertical position
        accuracyBoard.setFill(Color.BLACK);
        pane.getChildren().add(accuracyBoard);
    }

    private void updateAccuracyText() {
        game.setAccuracy((double) game.getSuccessfulShoot() / game.getAllShoots() * 100);
        accuracyBoard.setText("Accuracy: " + (int) game.getAccuracy());
    }

    public void update() {
        updateAccuracyText();
    }
}

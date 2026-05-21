package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import model.Plane;
import model.Player;
import view.HelloMenu;
import view.MainMenu;

import java.io.IOException;
import java.util.Objects;

public class AvatarMenuController {

    @FXML
    private Button file;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private ImageView image7;
    @FXML
    private ImageView image8;

    @FXML
    private void initialize() {
        setInitializeImages();
    }

    private void setInitializeImages() {

        for (int i = 1; i < 9; i++) {
            Image image = new Image(Objects.requireNonNull(Plane.class.getResource("/images/" + i + ".png")).toExternalForm());
            if (i == 1)
                image1.setImage(image);
            else if (i == 2)
                image2.setImage(image);
            else if (i == 3)
                image3.setImage(image);
            else if (i == 4)
                image4.setImage(image);
            else if (i == 5)
                image5.setImage(image);
            else if (i == 6)
                image6.setImage(image);
            else if (i == 7)
                image7.setImage(image);
            else image8.setImage(image);
        }

    }


    public void change1() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("Shy Girl");
        alert.setContentText("do you choose this avatar");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Player.getLoggedInPlayer().setImage(image1.getImage());
            }
        });
    }

    public void change2() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("Play boy");
        alert.setContentText("do you choose this avatar");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Player.getLoggedInPlayer().setImage(image2.getImage());
            }
        });
    }

    public void change3() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("Engineer");
        alert.setContentText("do you choose this avatar");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Player.getLoggedInPlayer().setImage(image3.getImage());
            }
        });
    }

    public void change4() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("Clerk");
        alert.setContentText("do you choose this avatar");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Player.getLoggedInPlayer().setImage(image4.getImage());
            }
        });
    }

    public void change5() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("Lumber jack");
        alert.setContentText("do you choose this avatar");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Player.getLoggedInPlayer().setImage(image5.getImage());
            }
        });
    }

    public void change6() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("Manager");
        alert.setContentText("do you choose this avatar");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Player.getLoggedInPlayer().setImage(image6.getImage());
            }
        });
    }

    public void change7() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("Old lawyer");
        alert.setContentText("do you choose this avatar");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Player.getLoggedInPlayer().setImage(image7.getImage());
            }
        });
    }

    public void change8() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Apply");
        alert.setHeaderText("House keeper");
        alert.setContentText("do you choose this avatar");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Player.getLoggedInPlayer().setImage(image8.getImage());
            }
        });
    }

    public void dragAndDrop(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;

        if (db.hasFiles()) {
            // Get the first file from the dragboard
            java.io.File file = db.getFiles().get(0);

            // Do something with the file, e.g., load it into the ImageView
            loadImageIntoImageView(file);

            success = true;
        }

        // Set the transfer mode
        event.acceptTransferModes(TransferMode.COPY);
        event.setDropCompleted(success);
        event.consume();
    }

    private void loadImageIntoImageView(java.io.File file) {
        // Load the image from the file and set it in the ImageView
        Image image = new Image(file.toURI().toString());
        Player.getLoggedInPlayer().setImage(image);
    }


    public void back() {

        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

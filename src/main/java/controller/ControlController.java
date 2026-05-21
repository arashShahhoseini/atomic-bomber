package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import model.Plane;
import model.Player;
import view.HelloMenu;
import view.SettingMenu;

import java.io.IOException;
import java.util.Objects;

public class ControlController {

    @FXML
    private ImageView image;
    @FXML
    private TextField up;
    @FXML
    private TextField left;
    @FXML
    private TextField right;
    @FXML
    private TextField down;

    @FXML
    private void initialize() {
        setImage();
    }

    private void setImage() {
        image.setImage(new Image(Objects.requireNonNull(Plane.class.getResource("/images/apply.png")).toExternalForm()));
    }

    public void back(MouseEvent mouseEvent) {

        SettingMenu settingMenu = new SettingMenu();
        try {
            settingMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void apply(MouseEvent mouseEvent) {

        Player player = Player.getLoggedInPlayer();
        player.setMoveUp(KeyCode.valueOf(up.getText()));
        player.setMoveDown(KeyCode.valueOf(down.getText()));
        player.setMoveLeft(KeyCode.valueOf(left.getText()));
        player.setMoveRight(KeyCode.valueOf(right.getText()));
    }
}

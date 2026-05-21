module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    exports view;
    opens view to javafx.fxml;
    exports controller;
    opens controller to javafx.fxml;
    exports view.animation;
    opens view.animation to javafx.fxml;
}
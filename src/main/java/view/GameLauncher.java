package view;

import controller.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import view.animation.*;

import java.io.IOException;
import java.util.Objects;

public class GameLauncher extends Application {

    private final double WIDTH = 1080;
    private final double HEIGHT = 720;
    private final Pane pane;
    private final Game game;
    private Plane plane;
    private Text killsText;
    private Text AtomicBombNumber;
    private Text clusterNumber;
    private Text wave;
    private Text accuracy;
    private Text HP;
    private Text freeze;
    private int currentWave = 1;

    public GameLauncher(String username) {
        pane = new Pane();
        setSize(pane);
        pane.setBackground(new Background(createBackgroundImage()));
        game = new Game(username);
        startWave1();
    }

    @Override
    public void start(Stage stage) throws IOException {

        pane.getChildren().addAll(plane, game.getBuildings(), game.getBases(), game.getTrees(), game.getTrucks(), game.getTanks(), game.getMigs());

        MediaPlayer mediaPlayer = game.getMediaPlayer();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        plane.requestFocus();

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        Duration duration = Duration.seconds(5);
        KeyFrame keyFrame = new KeyFrame(duration, event -> {
            if (checkToGoNextWave()) {
                switch (currentWave) {
                    case 2 -> startWave2();
                    case 3 -> startWave3();
                    case 4 -> finish(timeline);
                }
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();


        Timeline timeline2 = new Timeline();
        timeline2.setCycleCount(Timeline.INDEFINITE);
        Duration duration2 = Duration.seconds(1);
        KeyFrame keyFrame2 = new KeyFrame(duration2, event -> updateData());
        timeline2.getKeyFrames().add(keyFrame2);
        timeline2.play();

    }


    private void updateData() {
        if (killsText == null) {
            killsText = new Text();
            killsText.setFont(Font.font("Arial", 20));
            killsText.setFill(Color.BLACK);
            killsText.setX(155);
            killsText.setY(25);
            pane.getChildren().add(killsText);
        }
        if (AtomicBombNumber == null) {
            AtomicBombNumber = new Text();
            AtomicBombNumber.setFont(Font.font("Arial", 20));
            AtomicBombNumber.setFill(Color.BLACK);
            AtomicBombNumber.setX(280);
            AtomicBombNumber.setY(25);
            pane.getChildren().add(AtomicBombNumber);
        }
        if (clusterNumber == null) {
            clusterNumber = new Text();
            clusterNumber.setFont(Font.font("Arial", 20));
            clusterNumber.setFill(Color.BLACK);
            clusterNumber.setX(480);
            clusterNumber.setY(25);
            pane.getChildren().add(clusterNumber);
        }
        if (HP == null) {
            HP = new Text();
            HP.setFont(Font.font("Arial", 20));
            HP.setFill(Color.BLACK);
            HP.setX(800);
            HP.setY(25);
            pane.getChildren().add(HP);
        }
        if (wave == null) {
            wave = new Text();
            wave.setFont(Font.font("Arial", 14));
            wave.setFill(Color.BLACK);
            wave.setX(6);
            wave.setY(20);
            pane.getChildren().add(wave);
        }
        if (accuracy == null) {
            accuracy = new Text();
            accuracy.setFont(Font.font("Arial", 20));
            accuracy.setFill(Color.BLACK);
            accuracy.setX(630);
            accuracy.setY(25);
            pane.getChildren().add(accuracy);
        }
        if (freeze == null) {
            freeze = new Text();
            freeze.setFont(Font.font("Arial", 20));
            freeze.setFill(Color.RED);
            freeze.setX(900);
            freeze.setY(25);
            pane.getChildren().add(freeze);
        }
        int kills = game.getKills();
        killsText.setText("Kills: " + kills);
        int AtomicBombs = plane.getAtomicBombNumber();
        AtomicBombNumber.setText("AtomicBombs: " + AtomicBombs);
        int clusters = plane.getClusterNumber();
        clusterNumber.setText("Clusters: " + clusters);
        wave.setText("wave: " + game.getLastWave());
        accuracy.setText("Accuracy: " + (int) game.getAccuracy() + "%");
        HP.setText("HP: " + plane.getHP());
        freeze.setText("FREEZE");
        if (game.getFreezeNumber() > 3 && game.getFreezeNumber() <= 5)
            freeze.setFill(Color.YELLOW);
        else if (game.getFreezeNumber() > 5) {
            freeze.setFill(Color.GREEN);
            game.setCanFreeze(true);
        }

    }


    private boolean checkToGoNextWave () {

        int remainingObjects = game.getTanks().getChildren().size() +
                game.getTrucks().getChildren().size() +
                game.getBuildings().getChildren().size() +
                game.getMigs().getChildren().size() +
                game.getBases().getChildren().size();

        return remainingObjects == 0;
    }

    private void startWave1() {
        int randomI = (int) (Math.random() * 2);

        createBase();
        createPlane();
        createBuilding();

        for (int i = 0; i < 3; i++) {
            createTank();
        }

        for (int i = randomI; i < 4; i++) {
            createTrees();
            createTruck();
        }

        plane.getPlaneAnimation().play();
        game.getTrucks().getChildren().forEach(truck -> ((Truck) truck).getTruckAnimation().play());
        game.getTanks().getChildren().forEach(tank -> ((Tank) tank).getTankAnimation().play());

        game.setLastWave(currentWave);
        currentWave = 2;
    }

    private void startWave2() {

        pane.setBackground(new Background(createBackgroundImage()));
        game.setAccuracy((double) game.getSuccessfulShoot() / game.getAllShoots() * 100);
        int randomI = (int) (Math.random() * 2);

        for (int i = randomI; i < 6; i++) {
            createTrees();
            createTruck();
            createTank();
        }

        for (int i = 0; i < 2; i++) {
            createBase();
            createBuilding();
        }

        game.getTrucks().getChildren().forEach(truck -> ((Truck) truck).getTruckAnimation().play());
        game.getTanks().getChildren().forEach(tank -> ((Tank) tank).getTankAnimation().play());

        game.setLastWave(currentWave);
        currentWave = 3;
    }

    private void startWave3() {

        pane.setBackground(new Background(createBackgroundImage()));
        game.setAccuracy((double) game.getSuccessfulShoot() / game.getAllShoots() * 100);
        int randomI = (int) (Math.random() * 2);

        for (int i = randomI; i < 9; i++) {
            createTrees();
            createTruck();
            createTank();
        }

        for (int i = 0; i < 3; i++) {
            createBase();
            createMig();
            createBuilding();
        }

        game.getTrucks().getChildren().forEach(truck -> ((Truck) truck).getTruckAnimation().play());
        game.getTanks().getChildren().forEach(tank -> ((Tank) tank).getTankAnimation().play());
        game.getMigs().getChildren().forEach(mig -> ((Mig) mig).getMigAnimation().play());

        game.setLastWave(currentWave);
        currentWave = 4;
    }

    private void createTruck() {
        Truck truck = new Truck(86, 47, game);
        truck.setTruckAnimation(new TruckAnimation(pane, game, truck));
        game.getTrucks().getChildren().add(truck);
        if (truck.getX() < 0) truck.getTruckAnimation().setSpeed(-1.5);
    }

    private void createTank() {
        Tank tank = new Tank(114, 50, game);
        tank.setTankAnimation(new TankAnimation(pane, game, tank, plane));
        game.getTanks().getChildren().add(tank);

        switch (Game.getGameMode()) {
            case "easy" -> {
                tank.setRadius(300);
                tank.getTankAnimation().setSpeed(0.9);
                if (tank.getX() > 1000) tank.getTankAnimation().setSpeed(-0.9);
            }
            case "medium" -> {
                tank.setRadius(600);
                tank.getTankAnimation().setSpeed(1.8);
                if (tank.getX() > 1000) tank.getTankAnimation().setSpeed(-1.8);
            }
            case "hard" -> {
                tank.setRadius(900);
                tank.getTankAnimation().setSpeed(2.7);
                if (tank.getX() > 1000) tank.getTankAnimation().setSpeed(-2.7);
            }
        }
    }

    private void createMig() {
        Mig mig = new Mig(99, 34, game);
        mig.setMigAnimation(new MigAnimation(pane, game, mig, plane));
        game.getMigs().getChildren().add(mig);

        switch (Game.getGameMode()) {
            case "easy" -> {
                mig.setRadius(300);
                mig.getMigAnimation().setSpeed(1.6);
                if (mig.getX() > 1000) mig.getMigAnimation().setSpeed(-1.6);
            }
            case "medium" -> {
                mig.setRadius(600);
                mig.getMigAnimation().setSpeed(3.2);
                if (mig.getX() > 1000) mig.getMigAnimation().setSpeed(-3.2);
            }
            case "hard" -> {
                mig.setRadius(900);
                mig.getMigAnimation().setSpeed(4.8);
                if (mig.getX() > 1000) mig.getMigAnimation().setSpeed(-4.8);
            }
        }
    }


    private void createTrees() {
        Tree tree = new Tree(game);
        game.getTrees().getChildren().add(tree);
    }

    private void createBuilding() {
        Building building = new Building(game);
        game.getBuildings().getChildren().add(building);
    }

    private void createBase() {

        Base base = new Base(game);
        game.getBases().getChildren().add(base);
    }

    private void createPlane() {

        Player player = Player.getLoggedInPlayer();
        plane = new Plane(game);
        plane.setPlaneAnimation(new PlaneAnimation(plane));
        plane.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.RIGHT || keyEvent.getCode() == player.getMoveRight()) {
                GameController.moveRight(plane);
            } else if (keyEvent.getCode() == KeyCode.LEFT || keyEvent.getCode() == player.getMoveLeft()) {
                GameController.moveLeft(plane);
            } else if (keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == player.getMoveUp()) {
                GameController.moveUp(plane);
            } else if (keyEvent.getCode() == KeyCode.DOWN || keyEvent.getCode() == player.getMoveDown()) {
                GameController.moveDown(plane, HEIGHT, pane);
            } else if (keyEvent.getCode() == KeyCode.SPACE) {
                GameController.shootRocket(pane, plane, game);
            } else if (keyEvent.getCode() == KeyCode.R && plane.getAtomicBombNumber() > 0) {
                GameController.shootAtomicRocket(pane, plane, game);
            } else if (keyEvent.getCode() == KeyCode.C && plane.getClusterNumber() > 0) {
                GameController.shootCluster(pane, plane, game);
            } else if (keyEvent.getCode() == KeyCode.G) {
            GameController.addAtomicBomb(plane);
            } else if (keyEvent.getCode() == KeyCode.T) {
                GameController.addTank(plane, pane, game);
            } else if (keyEvent.getCode() == KeyCode.CONTROL) {
                GameController.addCluster(plane);
            } else if (keyEvent.getCode() == KeyCode.P) {
                GameController.goToNextWave(game, pane);
            } else if (keyEvent.getCode() == KeyCode.H) {
                GameController.addHP(plane);
            } else if (keyEvent.getCode() == KeyCode.TAB && game.isCanFreeze()) {
                freeze.setFill(Color.RED);
                game.setCanFreeze(false);
                game.setFreezeNumber(0);
                GameController.freeze(plane, game, pane);
            } else if (keyEvent.getCode() == KeyCode.ESCAPE) {
            GameController.exit();
            }
        });
    }

    public void setSize(Pane pane) {
        pane.setMaxHeight(HEIGHT);
        pane.setMinHeight(HEIGHT);
        pane.setMaxWidth(WIDTH);
        pane.setMinWidth(WIDTH);
    }

    public BackgroundImage createBackgroundImage() {
        Image image = new Image(Objects.requireNonNull(Game.class.getResource("/images/environment.png")).toExternalForm(), WIDTH, HEIGHT, false, false);
        return new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(50, 50, true, true, true, true)
        );
    }

    private void finish(Timeline timeline) {

        game.setLastWave(currentWave);
        timeline.stop();
        FinishGameMenu finishGameMenu = new FinishGameMenu();
        try {
            finishGameMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

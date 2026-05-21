package controller;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import model.*;
import view.HelloMenu;
import view.PauseMenu;
import view.animation.*;

import java.io.IOException;
import java.util.Objects;

public class GameController {

    public static void moveRight(Plane plane) {

        plane.getPlaneAnimation().setSpeed(3);
        plane.getPlaneAnimation().play();

    }

    public static void moveLeft(Plane plane) {

        plane.getPlaneAnimation().setSpeed(-3);
        plane.getPlaneAnimation().play();

    }

    public static void shootRocket (Pane pane, Plane plane, Game game) {

        game.setAllShoots(game.getAllShoots() + 1);
        Rocket rocket = new Rocket(plane);
        int planeIndex = pane.getChildren().indexOf(plane);
        pane.getChildren().add(planeIndex, rocket);
        ShootingAnimation shooting = new ShootingAnimation(game, rocket, pane, plane.getPlaneAnimation().getSpeed(), plane);
        shooting.play();
    }

    public static void shootAtomicRocket(Pane pane, Plane plane, Game game) {

        plane.setAtomicBombNumber(plane.getAtomicBombNumber() - 1);
        game.setAllShoots(game.getAllShoots() + 1);
        AtomicRocket atomicRocket = new AtomicRocket(plane);
        int planeIndex = pane.getChildren().indexOf(plane);
        pane.getChildren().add(planeIndex, atomicRocket);
        ShootingAnimation shooting = new ShootingAnimation(game, atomicRocket, pane, plane.getPlaneAnimation().getSpeed(), plane);
        shooting.play();
    }

    public static void shootCluster(Pane pane, Plane plane, Game game) {

        plane.setClusterNumber(plane.getClusterNumber() - 1);
        game.setAllShoots(game.getAllShoots() + 1);
        Cluster cluster = new Cluster(plane);
        int planeIndex = pane.getChildren().indexOf(plane);
        pane.getChildren().add(planeIndex, cluster);
        ShootingAnimation shooting = new ShootingAnimation(game, cluster, pane, plane.getPlaneAnimation().getSpeed(), plane);
        shooting.play();
    }

    public static void moveUp(Plane plane) {

        plane.setY(Math.max(plane.getY() - 20, 20));
    }

    public static void moveDown(Plane plane, double HEIGHT, Pane pane) {

        plane.setY(Math.min(plane.getY() + 20, HEIGHT - plane.getWIDTH() - 90));
        if (plane.getY() == 596 && pane.getChildren().contains(plane)) {

            System.out.println("1");
            PlaneExplosionAnimation planeExplosionAnimation = new PlaneExplosionAnimation(plane, pane);
            planeExplosionAnimation.play();
        }
    }

    public static void tankShoot(TankAnimation tankAnimation, Tank tank, Plane plane, Game game) {
        if (tankAnimation.getPane() != null) {
            TankBomb tankBomb = new TankBomb(tank);
            // Add the tankBomb to the pane, just after the tank
            int tankIndex = tankAnimation.getPane().getChildren().indexOf(tank);
            tankAnimation.getPane().getChildren().add(tankIndex + 1, tankBomb);
            TankShootingAnimation tankShootingAnimation = new TankShootingAnimation(tank, game, tankBomb, tankAnimation.getPane(), plane);
            findingPlane(tank, plane, tankShootingAnimation);
            tankShootingAnimation.play();
        } else {
            // Handle the case when pane is null
            System.out.println("pane is null, unable to shoot");
        }
    }

    private static void findingPlane(Tank tank, Plane plane, TankShootingAnimation tankShootingAnimation) {

        double x = plane.getX() - tank.getX();
        double speed = tank.getTankAnimation().getSpeed();
        if (x < 30) {
            tankShootingAnimation.setSpeedX(1);
            tankShootingAnimation.setSpeedY(2.82);
            if (speed < 0) tankShootingAnimation.setSpeedX(-1);
        }
        else if (x < 120) {
            tankShootingAnimation.setSpeedX(1.3);
            tankShootingAnimation.setSpeedY(2.7);
            if (speed < 0) tankShootingAnimation.setSpeedX(-1.3);
        }
        else if (x < 240) {
            tankShootingAnimation.setSpeedX(2.7);
            tankShootingAnimation.setSpeedY(1.3);
            if (speed < 0) tankShootingAnimation.setSpeedX(-2.7);
        }
        else {
            tankShootingAnimation.setSpeedX(2.82);
            tankShootingAnimation.setSpeedY(1);
            if (speed < 0) tankShootingAnimation.setSpeedX(-2.82);
        }
    }

    public static void migShoot(MigAnimation migAnimation, Mig mig, Plane plane, Game game) {

        if (migAnimation.getPane() != null && !game.isMigFreeze()) {
            MigBomb migBomb = new MigBomb(mig);
            // Add the tankBomb to the pane, just after the tank
            int migIndex = migAnimation.getPane().getChildren().indexOf(mig);
            migAnimation.getPane().getChildren().add(migIndex + 1, migBomb);
            MigShootAnimation migShootAnimation = new MigShootAnimation(mig, game, migBomb, migAnimation.getPane(), plane);
            findingPlane2(mig, plane, migShootAnimation);
            migShootAnimation.play();
        } else {
            // Handle the case when pane is null
            System.out.println("pane is null, unable to shoot");
        }
    }

    private static void findingPlane2(Mig mig, Plane plane, MigShootAnimation migShootAnimation) {
        double y = plane.getY() - mig.getY();
        double x = plane.getX() - mig.getX();
        double speed = mig.getMigAnimation().getSpeed();

        if ((x > 0 && speed > 0) || (x < 0 && speed < 0)) {
            if (y > 0) {
                migShootAnimation.setSpeedX(2.7);
                migShootAnimation.setSpeedY(1.3);
                if (speed < 0) {
                    migShootAnimation.setSpeedX(-2.7);
                }
            } else if (y < 0) {
                migShootAnimation.setSpeedX(2.7);
                migShootAnimation.setSpeedY(-1.3);
                if (speed < 0) {
                    migShootAnimation.setSpeedX(-2.7);
                }
            }
        }
    }

    public static void addAtomicBomb(Plane plane) {

        plane.setAtomicBombNumber(plane.getAtomicBombNumber() + 1);
    }

    public static void addCluster(Plane plane) {

        plane.setClusterNumber(plane.getClusterNumber() + 1);
    }

    public static void addTank(Plane plane, Pane pane, Game game) {

        Tank tank = new Tank(114, 50, game);
        tank.setTankAnimation(new TankAnimation(pane, game, tank, plane));
        game.getTanks().getChildren().add(tank);
        tank.getTankAnimation().play();
    }

    public static void goToNextWave(Game game, Pane pane) {

        // Clear the game objects
        game.getTanks().getChildren().clear();
        game.getBuildings().getChildren().clear();
        game.getTrucks().getChildren().clear();
        game.getMigs().getChildren().clear();
        game.getTrees().getChildren().clear();

        // Remove all objects from the game
        for (Tank tank:
             Tank.getTanks()) {
            pane.getChildren().remove(tank);
            tank.getTankAnimation().stop();
        }
        for (Mig mig:
            Mig.getMigs()) {
            pane.getChildren().remove(mig);
            mig.getMigAnimation().stop();
        }
    }

    public static void addHP(Plane plane) {
        plane.setHP(plane.getHP() + 1);
    }

    public static void freeze(Plane plane, Game game, Pane pane) {

        pane.setBackground(new Background(createBackgroundImage()));
        game.setMigFreeze(true);
        for (Tank tank:
                Tank.getTanks()) {
            tank.getTankAnimation().stop();
        }
        for (Mig mig:
                Mig.getMigs()) {
            mig.getMigAnimation().stop();
        }
        for (Truck truck:
                Truck.getTrucks()) {
            truck.getTruckAnimation().stop();
        }
    }

    private static BackgroundImage createBackgroundImage() {
        Image image = new Image(Objects.requireNonNull(Game.class.getResource("/images/freeze.png")).toExternalForm(), 1080, 720, false, false);
        return new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(50, 50, true, true, true, true)
        );
    }


    public static void exit() {

        PauseMenu pauseMenu = new PauseMenu();
        try {
            pauseMenu.start(HelloMenu.stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

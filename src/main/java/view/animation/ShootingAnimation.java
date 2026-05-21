package view.animation;

import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.*;

public class ShootingAnimation extends Transition {

    private final Game game;
    private final Bombs bomb;
    private final Pane pane;
    private final Plane plane;
    private final double planeSpeed;
    private double speed = 0.4;
    private double speed2 = 3;

    public ShootingAnimation(Game game, Bombs bomb, Pane pane, double planeSpeed, Plane plane) {
        this.game = game;
        this.bomb = bomb;
        this.pane = pane;
        this.plane = plane;
        this.planeSpeed = planeSpeed;
        double duration = 60;
        this.setCycleDuration(Duration.millis(duration));
        this.setCycleCount(-1);
        Sound.DROP.getAudioClip().play();
    }


    @Override
    protected void interpolate(double v) {

        double y = bomb.getY() + speed;
        double x = bomb.getX() + speed2;
        if (planeSpeed < 0)
            x = bomb.getX() - speed2;

        if (bomb.getName().equals("R") || bomb.getName().equals("C")) {
            for (Node child : game.getTrees().getChildren()){
                Tree tree = (Tree) child;
                if (tree.getBoundsInParent().intersects(bomb.getBoundsInParent())) {

                    if (tree.isHit()) continue;
                    tree.setHit(true);
                    game.setSuccessfulShoot(game.getSuccessfulShoot() + 1);
                    pane.getChildren().remove(bomb);
                    TreeAnimation treeAnimation = new TreeAnimation(tree, pane, game);
                    treeAnimation.play();
                    this.stop();
                    break;
                }
            }

            for (Node child : game.getBuildings().getChildren()){
                Building building = (Building) child;
                if (building.getBoundsInParent().intersects(bomb.getBoundsInParent())) {

                    if (building.isHit()) continue;
                    building.setHit(true);
                    game.setScore(game.getScore() + building.getScore());
                    game.setKills(game.getKills() + 4);
                    game.setFreezeNumber(game.getFreezeNumber() + 1);
                    game.setSuccessfulShoot(game.getSuccessfulShoot() + 1);
                    pane.getChildren().remove(building);
                    pane.getChildren().remove(bomb);

                    BuildingExplosionAnimation buildingExplosionAnimation = new BuildingExplosionAnimation(building, pane, game.getBuildings());
                    buildingExplosionAnimation.play();

                    ClusterBubble clusterBubble = new ClusterBubble(building);
                    pane.getChildren().add(clusterBubble);
                    ClusterBubbleAnimation clusterBubbleAnimation = new ClusterBubbleAnimation(clusterBubble, game, pane, plane);
                    clusterBubbleAnimation.play();

                    Sound.EXPLOSION.getAudioClip().play();
                    Building.remove(building);

                    this.stop();
                    break;
                }
            }

            for (Node child : game.getTrucks().getChildren()){
                Truck truck = (Truck) child;
                if (truck.getBoundsInParent().intersects(bomb.getBoundsInParent())) {

                    if (truck.isHit()) continue;
                    truck.setHit(true);
                    game.setScore(game.getScore() + truck.getScore());
                    game.setKills(game.getKills() + 1);
                    game.setFreezeNumber(game.getFreezeNumber() + 1);
                    game.setSuccessfulShoot(game.getSuccessfulShoot() + 1);
                    game.getTrucks().getChildren().remove(truck);
                    pane.getChildren().remove(truck);
                    pane.getChildren().remove(bomb);

                    Sound.EXPLOSION.getAudioClip().play();

                    Truck.remove(truck);
                    this.stop();
                    break;
                }
            }

            for (Node child : game.getTanks().getChildren()){
                Tank tank = (Tank) child;
                if (tank.getBoundsInParent().intersects(bomb.getBoundsInParent())) {

                    if (tank.isHit()) continue;
                    tank.setHit(true);
                    game.setScore(game.getScore() + tank.getScore());
                    game.setKills(game.getKills() + 1);
                    game.setFreezeNumber(game.getFreezeNumber() + 1);
                    game.setSuccessfulShoot(game.getSuccessfulShoot() + 1);
                    pane.getChildren().remove(bomb);
                    this.stop();

                    Sound.EXPLOSION.getAudioClip().play();

                    TankExplosionAnimation tankExplosionAnimation = new TankExplosionAnimation(tank, pane, game.getTanks(), game);
                    tankExplosionAnimation.play();

                    Tank.remove(tank);
                    break;
                }
            }

            for (Node child : game.getBases().getChildren()){
                Base base = (Base) child;
                if (base.getBoundsInParent().intersects(bomb.getBoundsInParent())) {

                    if (base.isHit()) continue;
                    base.setHit(true);
                    game.setSuccessfulShoot(game.getSuccessfulShoot() + 1);
                    game.setScore(game.getScore() + base.getScore());
                    game.setKills(game.getKills() + 2);
                    game.setFreezeNumber(game.getFreezeNumber() + 1);
                    game.getBases().getChildren().remove(base);
                    pane.getChildren().remove(base);
                    pane.getChildren().remove(bomb);

                    AtomBubble atomBubble = new AtomBubble(base);
                    pane.getChildren().add(atomBubble);
                    AtomBubbleAnimation atomBubbleAnimation = new AtomBubbleAnimation(atomBubble, game, pane, plane);
                    atomBubbleAnimation.play();

                    Sound.EXPLOSION.getAudioClip().play();
                    Base.remove(base);

                    this.stop();
                    break;
                }
            }
        }

        if (y >= 700) {

            pane.getChildren().remove(bomb);
            if (bomb.getName().equals("R")) {
                Sound.EXPLOSION.getAudioClip().play();
                Explosion explosion = new Explosion(bomb);
                pane.getChildren().add(explosion);
                BombExplosion bombExplosion = new BombExplosion(explosion, pane);
                bombExplosion.play();
            }
            else if (bomb.getName().equals("C")) {
                Sound.EXPLOSION.getAudioClip().play();
                ClusterExplosion clusterExplosion = new ClusterExplosion(bomb);
                pane.getChildren().add(clusterExplosion);
                ClusterExplosionAnimation clusterExplosionAnimation = new ClusterExplosionAnimation(clusterExplosion, pane);
                clusterExplosionAnimation.play();
            }
            else if (bomb.getName().equals("A")) {
                Sound.ATOM.getAudioClip().play();
                pane.getChildren().remove(bomb);
                AtomExplosion atomExplosion = new AtomExplosion(bomb);
                pane.getChildren().add(atomExplosion);
                AtomExplosionAnimation animation = new AtomExplosionAnimation(atomExplosion, pane);
                animation.play();

                for (Tank tank:
                        Tank.getTanks()) {
                    if (tank.getX() - bomb.getX() < 100 && bomb.getX() - tank.getX() < 100) {

                        game.setScore(game.getScore() + tank.getScore());
                        game.setKills(game.getKills() + 1);
                        game.setFreezeNumber(game.getFreezeNumber() + 1);
                        game.setSuccessfulShoot(game.getSuccessfulShoot() + 1);

                        TankExplosionAnimation tankExplosionAnimation = new TankExplosionAnimation(tank, pane, game.getTanks(), game);
                        tankExplosionAnimation.play();
                        tank.getTankAnimation().stop();
                        Tank.remove(tank);
                    }
                }
                for (Truck truck:
                        Truck.getTrucks()) {

                    if (truck.getX() - bomb.getX() < 100 && bomb.getX() - truck.getX() < 100) {

                        game.setScore(game.getScore() + truck.getScore());
                        game.setKills(game.getKills() + 1);
                        game.setFreezeNumber(game.getFreezeNumber() + 1);
                        game.setSuccessfulShoot(game.getSuccessfulShoot() + 1);

                        pane.getChildren().remove(truck);
                        game.getTrucks().getChildren().remove(truck);
                        Truck.remove(truck);
                    }
                }
                for (Building building:
                        Building.getBuildings()) {

                    if (building.getX() - bomb.getX() < 100 && bomb.getX() - building.getX() < 100) {

                        game.setScore(game.getScore() + building.getScore());
                        game.setKills(game.getKills() + 4);
                        game.setFreezeNumber(game.getFreezeNumber() + 1);
                        game.setSuccessfulShoot(game.getSuccessfulShoot() + 1);

                        ClusterBubble clusterBubble = new ClusterBubble(building);
                        pane.getChildren().add(clusterBubble);
                        ClusterBubbleAnimation clusterBubbleAnimation = new ClusterBubbleAnimation(clusterBubble, game, pane, plane);
                        clusterBubbleAnimation.play();

                        BuildingExplosionAnimation buildingExplosionAnimation = new BuildingExplosionAnimation(building, pane, game.getBuildings());
                        buildingExplosionAnimation.play();
                        Building.remove(building);
                    }
                }
                for (Base base:
                        Base.getBases()) {

                    if (base.getX() - bomb.getX() < 100 && bomb.getX() - base.getX() < 100) {

                        game.setScore(game.getScore() + base.getScore());
                        game.setKills(game.getKills() + 2);
                        game.setFreezeNumber(game.getFreezeNumber() + 1);
                        game.setSuccessfulShoot(game.getSuccessfulShoot() + 1);

                        AtomBubble atomBubble = new AtomBubble(base);
                        pane.getChildren().add(atomBubble);
                        AtomBubbleAnimation atomBubbleAnimation = new AtomBubbleAnimation(atomBubble, game, pane, plane);
                        atomBubbleAnimation.play();
                        pane.getChildren().remove(base);
                        game.getBases().getChildren().remove(base);
                        Base.remove(base);
                    }
                }

            }
            this.stop();
        }

        bomb.setY(y);
        if (speed2 > 0)
            bomb.setX(x);
        speed2 *= 0.99;
        speed += 0.02;

    }
}

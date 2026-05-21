package model;

import javafx.scene.shape.Rectangle;

public class Bombs extends Rectangle{

    private double WIDTH;
    private double HEIGHT;
    private final String name;

    public Bombs(int w, int h, Plane plane, String name) {
        super(w, h);
        setHEIGHT(h);
        setWIDTH(w);
        this.name = name;
        setY(plane.getY() + plane.getHEIGHT()/2 - getHEIGHT()/2 - 20);
        setX(plane.getX() + plane.getWIDTH()/2 - getWidth()/2 + 20);
    }

    public void setWIDTH(double WIDTH) {
        this.WIDTH = WIDTH;
    }

    public void setHEIGHT(double HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public double getWIDTH() {
        return WIDTH;
    }

    public double getHEIGHT() {
        return HEIGHT;
    }

    public String getName() {
        return name;
    }
}

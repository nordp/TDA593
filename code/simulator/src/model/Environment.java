package model;

import java.util.Collection;

public class Environment {
    private float height;
    private float width;
    private Collection<Wall> walls;

    //FIXME: Maybe default constructor?

    public Environment(float height, float width, Collection<Wall> walls){
        this.height = height;
        this.width = width;
        this.walls = walls;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public Collection<Wall> getWalls() {
        return walls;
    }

    public void setWalls(Collection<Wall> walls) {
        this.walls = walls;
    }

    public void addWall(Wall wall){
        this.walls.add(wall);
    }
}

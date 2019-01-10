package chalmers.tda593.y2018.g11.rovu.model;

import java.util.ArrayList;
import java.util.Collection;

public class Environment {
    private final float height;
    private final float width;
    private final Collection<Wall> walls;
    private final Collection<Area> logicalAreas;
	private final Collection<Area> physicalAreas;

    public Environment(
    		float height,
		    float width,
		    Collection<Wall> walls,
		    Collection<Area> logicalAreas,
		    Collection<Area> physicalAreas
    ){
        this.height = height;
        this.width = width;
        this.walls = walls == null ? new ArrayList<>() : new ArrayList<>(walls);
        this.logicalAreas =  logicalAreas == null ? new ArrayList<>() : new ArrayList<>(logicalAreas);
	    this.physicalAreas =  physicalAreas == null ? new ArrayList<>() : new ArrayList<>(physicalAreas);
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public Collection<Wall> getWalls() {
        return  new ArrayList<>(walls);
    }

	public Collection<Area> getLogicalAreas() {
		return  new ArrayList<>(logicalAreas);
	}

	public Collection<Area> getPhysicalAreas() {
		return  new ArrayList<>(physicalAreas);
	}
}

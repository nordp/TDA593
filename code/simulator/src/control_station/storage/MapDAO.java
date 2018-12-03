package control_station.storage;

import simbad.sim.Wall;

import java.util.Collection;

public interface MapDAO {
    public void add(Wall wall);
    public Collection<Wall> getWalls();
}

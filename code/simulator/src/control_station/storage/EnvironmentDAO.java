package control_station.storage;

import model.Area;
import model.Environment;
import simbad.sim.Wall;

import java.util.Collection;

public interface EnvironmentDAO {
    void store(Environment environment);
    Environment getEnvironment();
}

package chalmers.tda593.y2018.g11.rovu.control_station.storage;

import chalmers.tda593.y2018.g11.rovu.model.Environment;

public interface EnvironmentDAO {
    void store(Environment environment);
    Environment getEnvironment();
}

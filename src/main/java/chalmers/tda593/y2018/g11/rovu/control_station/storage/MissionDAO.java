package chalmers.tda593.y2018.g11.rovu.control_station.storage;

import chalmers.tda593.y2018.g11.rovu.model.Mission;

import java.util.Collection;

public interface MissionDAO {
    void store(Mission mission);
    Collection<Mission> getMissions();
    Mission getMission(int assignedRobot);
}

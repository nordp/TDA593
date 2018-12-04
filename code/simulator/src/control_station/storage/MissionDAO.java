package control_station.storage;

import model.Mission;

import java.util.Collection;

public interface MissionDAO {
    void store(Mission mission);
    Collection<Mission> getMissions();
    Mission getMission(int assignedRobot);
    // TODO should have some way of accessing mission data
}

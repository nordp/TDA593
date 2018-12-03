package control_station.storage;

import model.Mission;

public interface MissionDAO {
    public void store(Mission mission);
    // TODO should have some way of accessing mission data
}

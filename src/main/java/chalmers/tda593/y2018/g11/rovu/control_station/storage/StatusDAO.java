package chalmers.tda593.y2018.g11.rovu.control_station.storage;

import chalmers.tda593.y2018.g11.rovu.model.Status;

import java.util.Collection;

public interface StatusDAO {
    void store(Status robot);
    Status getStatus(int id);
    Collection<Status> getStatuses();
    Collection<Integer> getRobotIds();
}

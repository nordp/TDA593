package control_station.storage;

import model.Status;

import java.util.Collection;

public interface StatusDAO {
    void store(Status robot);
    Status getStatus(int id);
    Collection<Status> getStatuses();
    Collection<Integer> getRobotIds();
}

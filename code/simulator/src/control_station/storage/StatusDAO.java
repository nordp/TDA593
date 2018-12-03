package control_station.storage;

import model.Status;

import java.util.Collection;

public interface StatusDAO {
    public void store(Status robot);
    public Status getStatus(int id);
    public Collection<Integer> getRobotIds();
}

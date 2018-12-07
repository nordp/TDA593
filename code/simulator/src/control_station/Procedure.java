package control_station;

import model.Area;
import model.Status;

import java.util.Collection;

/**
 * Created by svante on 2018-12-01.
 */
public interface Procedure {
    Procedure update(Collection<Status> robots, Collection<Area> areas);
    int calculate(Collection<Status> robots, Collection<Area> areas);
}

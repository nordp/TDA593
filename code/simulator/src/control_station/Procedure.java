package control_station;

import model.Area;
import model.Status;

import java.util.Collection;

/**
 * Created by svante on 2018-12-01.
 */
abstract class Procedure {
    abstract Procedure update(Collection<Status> robots, Collection<Area> logicalAreas, Collection<Area> physicalAreas);

    abstract int calculate(Collection<Status> robots, Collection<Area> logicalAreas, Collection<Area> physicalAreas);

    int countPointsForAreas(Collection<Status> robots, Collection<Area> areas) {
        int points = 0;
        for (Status status : robots) {
            for (Area area : areas) {
                if (area.isInArea(status.getLocation())) {
                    points += area.getPoints();
                    break;
                }
            }
        }
        return points;
    }
}

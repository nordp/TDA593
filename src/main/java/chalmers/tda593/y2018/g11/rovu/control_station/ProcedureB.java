package chalmers.tda593.y2018.g11.rovu.control_station;

import chalmers.tda593.y2018.g11.rovu.model.Area;
import chalmers.tda593.y2018.g11.rovu.model.Status;

import java.util.Collection;

/**
 * Created by svante on 2018-12-01.
 */
class ProcedureB extends Procedure {

    @Override
    Procedure update(Collection<Status> robots, Collection<Area> logicalAreas, Collection<Area> physicalAreas) {
        for (Status s : robots) {
            for (Area a : physicalAreas) {
                if (a.isInArea(s.getLocation())) {
                    return new ProcedureA();
                }
            }
        }
        return new ProcedureB();
    }

    @Override
    public int calculate(Collection<Status> robots, Collection<Area> logicalAreas, Collection<Area> physicalAreas) {
        return countPointsForAreas(robots, logicalAreas);
    }


}

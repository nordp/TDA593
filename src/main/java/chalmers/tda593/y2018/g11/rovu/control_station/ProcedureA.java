package chalmers.tda593.y2018.g11.rovu.control_station;

import chalmers.tda593.y2018.g11.rovu.model.Area;
import chalmers.tda593.y2018.g11.rovu.model.Status;

import java.util.Collection;

/**
 * Created by svante on 2018-12-01.
 */
class ProcedureA extends Procedure {

    @Override
    Procedure update(Collection<Status> robots, Collection<Area> logicalAreas, Collection<Area> physicalAreas) {
        for (Status s : robots) {
            for (Area a : logicalAreas) {
                if (a.isInArea(s.getLocation())) {
                    return new ProcedureB();
                }
            }
        }
        return new ProcedureA();
    }

    /**
     * Calculates if each chalmers.tda593.y2018.g11.rovu.robot resides in an area
     * together with the amount the point it gets for
     * residing in this area.
     *
     * @param robots
     * @return int
     */
    @Override
    public int calculate(Collection<Status> robots, Collection<Area> logicalAreas, Collection<Area> physicalAreas) {

        return countPointsForAreas(robots, physicalAreas);
    }


}

//Break calculate down in to a function that returns true if the chalmers.tda593.y2018.g11.rovu.robot resides in a room?


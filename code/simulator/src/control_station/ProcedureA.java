package control_station;

import model.Area;
import model.Status;

import java.util.Collection;

/**
 * Created by svante on 2018-12-01.
 */
public class ProcedureA implements Procedure {

    @Override
    public Procedure update(Collection<Status> robots, Collection<Area> logicalAreas) {
        for (Status s: robots
        ) {
            for (Area a: logicalAreas
            ) {
                if(
                       a.isRobotInArea(s.getLocation())) {

                    return new ProcedureB();
                }
            }






        }

        return new ProcedureA();
    }

    //Bad practise to return new objects all the time?


    /**
     * Calculates if each robot resides in an area
     * together with the amount the point it gets for
     * residing in this area.
     * @param robots
     * @return int
     */
    @Override
    public int calculate(Collection<Status> robots, Collection<Area> physicalAreas) {
        int points = 0;

        for (Status s: robots
             ) {
            for (Area a: physicalAreas
                 ) {
                if(a.isRobotInArea(s.getLocation())) {
                    points++;
                }
            }






        }
         return points;
    }


}

//Break calculate down in to a function that returns true if the robot resides in a room?


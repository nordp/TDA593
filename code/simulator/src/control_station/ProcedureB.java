package control_station;

import model.Area;
import model.Status;

import java.util.Collection;

/**
 * Created by svante on 2018-12-01.
 */
public class ProcedureB implements Procedure {
    @Override
    public Procedure update(Collection<Status> robots, Collection<Area> physicalAreas) {
        for (Status s: robots
        ) {
            for (Area a: physicalAreas
            ) {
                if(
                        a.isRobotInArea(s.getLocation())) {

                    return new ProcedureA();
                }
            }






        }

        return new ProcedureB();
    }

    @Override
    public int calculate(Collection<Status> robots, Collection<Area> logicalAreas) {
        int points = 0;

        for (Status s: robots
        ) {
            for (Area a: logicalAreas
            ) {
                if(a.isRobotInArea(s.getLocation())) {
                    points += 2;
                }
            }






        }
        return points;
    }


}

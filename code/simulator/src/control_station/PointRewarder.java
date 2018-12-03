package control_station;
import model.Status;

import java.util.Collection;

/**
 * Created by svante on 2018-12-01.
 */
public class PointRewarder {
    private Procedure current;

    PointRewarder(){
        this.current = new ProcedureA(); //Defaulting to procedure A when initiating class, can be changed later
    }

    private int calculate(Collection<Status> robots) {
        //Not necessary, method exists in the current procedure
        //However, it should be replaced with a method that updates the points for each robot
        return 1;
    }
}

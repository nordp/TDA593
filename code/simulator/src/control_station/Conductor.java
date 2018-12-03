package control_station;
import model.Mission;
//import model.Strategy;


/**
 * Created by svante on 2018-12-01.
 * The "brain" of the entire system.
 * Responsible for calculating optimal routes for robots, commands them when necessary
 */
public class Conductor {

    Conductor(){
        //Should this class maybe be static?
    }

    void setMission(Mission mission, Strategy strategy,Robot robot/*Should this take a robot status instead?*/){
        //Is this used to store the current mission for a robot in the storage?
        //If so, this method should already exist in the storage package
    }

    private Mission strategize(Mission mission, Strategy strategy){
        return null;
    }

    private void runMission(Mission mission, int id){

    }
}

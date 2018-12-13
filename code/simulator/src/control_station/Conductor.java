package control_station;
import model.Mission;
import model.Strategy;
import robot.ControlStationInterface;
import java.util.Map;


/**
 * Created by svante on 2018-12-01.
 * The "brain" of the entire system.
 * Responsible for calculating optimal routes for robots, commands them when necessary
 */
public class Conductor {
    private RobotInterface robotInterface;
    public OperatorInterface operatorInterface;

    public Conductor(Map<Integer,ControlStationInterface> robots){
        this.robotInterface = new RobotInterface(robots);
        operatorInterface = new OperatorInterface(robotInterface);
        //Should this class maybe be static?
    }

    void setMission(Mission mission, Strategy strategy,int robot){
        //Is this used to store the current mission for a robot in the storage?
        //If so, this method should already exist in the storage package
    }

    private Mission strategize(Mission mission, Strategy strategy){
        return null;
    }

    private void runMission(Mission mission, int id){

    }
}

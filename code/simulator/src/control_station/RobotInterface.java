package control_station;
//import model;
import model.Instruction;
import robot.ControlStationInterface;

import java.util.Map;

/**
 * Created by svante on 2018-12-01.
 * An interface between the control station and the robot.
 * Handles communication and between the two packages as
 * well as storing data comm
 * Currently missing a way to get information from robots
 */
public class RobotInterface {

    private Map<Integer,ControlStationInterface> robots;
    //private RobotInterface instance; Might need to implement as a singleton, don't want more than one RobotInterface

    RobotInterface(Map<Integer, ControlStationInterface> robots){
        this.robots = robots;

    }

    /**
     * Param: id            - Control station interface? The key to a robot in the HashSet in Storage?
     *        Instruction   - Instruction needed to decide on a routine for a robot
     *
     * Dispatches an instruction to a robot with the identification 'id'
     */
    void dispatch(int id, Instruction instruction){
        System.out.println("dispatch");
        robots.get(id).notify(instruction);
    }


}

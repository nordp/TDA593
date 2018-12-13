package control_station;

import robot.ControlStationInterface;

import java.util.Map;

public class ControlStationFactory {

    public static OperatorInterface build(Map<Integer,ControlStationInterface> robots){
        RobotInterface robotInterface = new RobotInterface(robots);
        Conductor conductor = new Conductor(robotInterface);
        return new OperatorInterface(robotInterface, conductor);
    }

}

package chalmers.tda593.y2018.g11.rovu.control_station;

import chalmers.tda593.y2018.g11.rovu.robot.ControlStationInterface;

import java.util.Map;

public class ControlStationFactory {

    public static OperatorInterface build(Map<Integer,ControlStationInterface> robots){
        RobotInterface robotInterface = new RobotInterface(robots);
        Conductor conductor = new Conductor(robotInterface);
        new PointRewarder();
        return new OperatorInterface(robotInterface, conductor);
    }

}

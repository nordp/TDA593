package chalmers.tda593.y2018.g11.rovu.robot;

public class RobotFactory {

    public static ControlStationInterface build(int id, Actuator actuator, Sensor sensor){
        Controller controller = new Controller(id, actuator, sensor);
        return new ControlStationInterface(controller);
    }

}

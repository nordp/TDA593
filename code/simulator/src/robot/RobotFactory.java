package robot;

public class RobotFactory {

    public static ControlStationInterface build(int id, Actuator actuator, Sensor sensor){
        Controller controller = new Controller(id, actuator, sensor);
        return new ControlStationInterface(controller);
    }

}

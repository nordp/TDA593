package control_station;
import control_station.storage.StorageBroker;
import model.*;

//import model.Environment

/**
 * Created by svante on 2018-12-01.
 */
public class OperatorInterface {

    private RobotInterface robotInterface;
    private Conductor conductor;

    OperatorInterface(RobotInterface robotInterface, Conductor conductor){
        this.robotInterface = robotInterface;
        this.conductor = conductor;
    }

    Status getStatuses(){
        return null;
    }

    public void assignMission(Mission mission, Strategy strategy){
        conductor.setMission(mission, strategy);
    }

    public void assignAction(int id, Instruction instruction){
        robotInterface.dispatch(id,instruction);
    }


    public int getRewardPoints() {
        return StorageBroker.getRewardDAO().getReward();
    }

    public Environment getEnv() {

        return StorageBroker.getMapDAO().getEnvironment();
    }
}

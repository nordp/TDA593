package control_station;
import model.*;

import java.util.Collection;

import static control_station.storage.StorageBroker.getMapDAO;
import static control_station.storage.StorageBroker.getRewardDAO;
import static control_station.storage.StorageBroker.getStatusDAO;

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

    Status getStatus(int id){
        return getStatusDAO().getStatus(id);
    }

    public Collection<Status> getStatuses(){
        return getStatusDAO().getStatuses();
    }

    public void assignMission(Mission mission, Strategy strategy){
        conductor.setMission(mission, strategy);
    }

    public void assignAction(int id, Instruction instruction){
        robotInterface.dispatch(id,instruction);
    }


    public int getRewardPoints() {
        return getRewardDAO().getReward();
    }

    public Environment getEnv() {

        return getMapDAO().getEnvironment();
    }
}

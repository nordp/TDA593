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
    private Strategy strategy;
    StorageBroker storageBroker = new StorageBroker();

    OperatorInterface(RobotInterface robotInterface, Conductor conductor){
        this.robotInterface = robotInterface;
        this.conductor = conductor;
    }

    /*public static OperatorInterface getInstance(){
        return instance;
    }*/

    Status getStatuses(){
        return null;
    }

    public void assignMission(int id, Mission mission){
        System.out.println("I am here!!");
        System.out.println(mission.getAssignedRobot());
        if(id == 1){ strategy = Strategy.SHORTEST_ROUTE; }
        conductor.setMission(mission, strategy , mission.getAssignedRobot());
    }

    public void assignAction(int id, Instruction instruction){
        robotInterface.dispatch(id,instruction);
    }


    public int getRewardPoints() {
        return storageBroker.getRewardDAO().getReward();
    }

    public Environment getEnv() {

        return storageBroker.getMapDAO().getEnvironment();
    }
}

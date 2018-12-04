package control_station;
import model.Environment;
import model.Status;
import model.Mission;
import model.Instruction;
//import model.Environment

/**
 * Created by svante on 2018-12-01.
 */
public class OperatorInterface {

    private RobotInterface robotInterface;


    OperatorInterface(RobotInterface robotInterface){
        this.robotInterface = robotInterface;
    }

    /*public static OperatorInterface getInstance(){
        return instance;
    }*/

    Status getStatuses(){
        return null;
    }

    void assignMission(int id, Mission mission){

    }

    public void assignAction(int id, Instruction instruction){
        robotInterface.dispatch(id,instruction);
    }

    Environment getMap(){
        return null;
    }

    int getPoints(){
        return 1;
    }
}

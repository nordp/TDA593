package control_station;
import model.Status;
import model.Mission;
import model.Instruction;

import java.util.HashMap;
//import model.Map

/**
 * Created by svante on 2018-12-01.
 */
public class OperatorInterface {

    private static final OperatorInterface instance = new OperatorInterface();
    private RobotInterface robotInterface;


    OperatorInterface(){
        //robotInterface = new RobotInterface(new HashMap<>(1));
    }

    public static OperatorInterface getInstance(){
        return instance;
    }

    Status getStatuses(){
        return null;
    }

    void assignMission(int id, Mission mission){

    }

    public void assignAction(int id, Instruction instruction){
        robotInterface.dispatch(id,instruction);
    }

    /*Map getMap(){
        return null;
    }*/

    int getPoints(){
        return 1;
    }
}

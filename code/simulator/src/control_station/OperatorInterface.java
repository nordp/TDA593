package control_station;
import model.Status;
import model.Mission;
import model.Instruction;
//import model.Map

/**
 * Created by svante on 2018-12-01.
 */
public class OperatorInterface {

    private static final OperatorInterface instance = new OperatorInterface();

    OperatorInterface(){
    }

    public static OperatorInterface getInstance(){
        return instance;
    }

    Status getStatuses(){
        return null;
    }

    void assignMission(int id, Mission mission){

    }

    void assignAction(int id, Instruction instruction){

    }

    Map getMap(){
        return null;
    }

    int getPoints(){
        return 1;
    }
}
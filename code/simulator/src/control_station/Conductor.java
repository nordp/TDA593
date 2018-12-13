package control_station;

import model.Coordinate;
import model.Mission;
import model.MovementInstruction;
import model.Strategy;

import java.util.List;


/**
 * Created by svante on 2018-12-01.
 * The "brain" of the entire system.
 * Responsible for calculating optimal routes for robots, commands them when necessary
 */
public class Conductor {
    private RobotInterface robotInterface;

    public Conductor(RobotInterface robotInterface){
        this.robotInterface = robotInterface;
    }

    public void setMission(Mission mission, Strategy strategy, int robot){
        //Is this used to store the current mission for a robot in the storage?
        //If so, this method should already exist in the storage package
        System.out.println("SetMission");
        MovementInstruction moveCoor;
            List<Coordinate> missionList = mission.getPoints();
            for(int i = 0; i < missionList.size(); i++){
                moveCoor = new MovementInstruction(true , missionList.get(i));
                robotInterface.dispatch(robot, moveCoor);
            }

    }

    private Mission strategize(Mission mission, Strategy strategy){
        return null;
    }

    private void runMission(Mission mission, int id){

    }
}

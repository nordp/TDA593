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
class Conductor {
    private RobotInterface robotInterface;

    Conductor(RobotInterface robotInterface){
        this.robotInterface = robotInterface;
    }

    void setMission(Mission mission, Strategy strategy){
        //Is this used to store the current mission for a robot in the storage?
        //If so, this method should already exist in the storage package
        Mission strategized = strategize(mission, strategy);
        MovementInstruction moveCoor;
        List<Coordinate> missionList = strategized.getPoints();
        for(int i = 0; i < missionList.size(); i++){
            moveCoor = new MovementInstruction(true , missionList.get(i));
            robotInterface.dispatch(mission.getAssignedRobot(), moveCoor);
        }

    }

    private Mission strategize(Mission mission, Strategy strategy){
        return Strategizer.strategize(strategy, mission);
    }

    private void runMission(Mission mission, int id){

    }
}

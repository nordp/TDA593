package control_station;

import control_station.storage.Storage;
import model.*;

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

    void setMission(Mission mission, Strategy strategy, int robot){
        //Is this used to store the current mission for a robot in the storage?
        //If so, this method should already exist in the storage package
        MovementInstruction moveCoor;
        Storage store = new Storage();
        List<Coordinate> missionList = mission.getPoints();
        int i = 0;
        while(i < missionList.size()){
            Status stat = store.getStatus(robot);
            if (stat.getLocation().equals(missionList.get(i)) || i == 0) {
                moveCoor = new MovementInstruction(true, missionList.get(i));
                robotInterface.dispatch(robot, moveCoor);
                i++;
            }
        }
            /*for(int i = 0; i < missionList.size(); i++) {
                Status stat = store.getStatus(robot);
                if (stat.getLocation() == missionList.get(i)) {
                    moveCoor = new MovementInstruction(true, missionList.get(i));
                    robotInterface.dispatch(robot, moveCoor);
                }

            }*/

    }

    private Mission strategize(Mission mission, Strategy strategy){
        return null;
    }

    private void runMission(Mission mission, int id){

    }
}

package model;

import java.util.List;

public class Mission {

    private int assignedRobot;
    private List<Coordinate> missionPoints;

    public Mission(int robotId, List<Coordinate> missionPoints){
        this.assignedRobot = robotId;
        this.missionPoints = missionPoints;
    }

    public List<Coordinate> getPoints() {
        return missionPoints;
    }

    public int getAssignedRobot(){
        return assignedRobot;
    }
}

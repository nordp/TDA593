package chalmers.tda593.y2018.g11.rovu.model;

import java.util.ArrayList;
import java.util.List;

public class Mission {

    private final int assignedRobot;
    private final List<Coordinate> missionPoints;

    public Mission(int robotId, List<Coordinate> missionPoints){
        this.assignedRobot = robotId;
        this.missionPoints = missionPoints == null ? new ArrayList<>() : new ArrayList<>(missionPoints);
    }

    public List<Coordinate> getPoints() {
        return new ArrayList<>(missionPoints);
    }

    public int getAssignedRobot(){
        return this.assignedRobot;
    }
}

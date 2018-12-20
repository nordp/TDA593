package user_interface;
import model.Mission;
import model.Coordinate;

import java.util.List;

public class MissionComposer {
    private Mission assembledMission = null; // Should ofc not be null when sending a mission.
    private Mission changedMission = null; // Should ofc not be null when sending a mission.

    public Mission createMission(List<Coordinate> missionPoints, int robot) {
        assembledMission = new Mission(robot,missionPoints); // TODO: Change to chosen robot ID!
        return assembledMission;
    }

    // Should this maybe be done in the conductor instead? Since we have no notion of past missions here.
    public Mission changeMission(Mission oldMission, Mission mission, int strategyId) {return changedMission;}

}

package user_interface;
import model.Mission;
import model.Coordinate;

import java.util.List;

public class MissionComposer {
    private Mission assembledMission = null; // Should ofc not be null when sending a mission.
    private Mission changedMission = null; // Should ofc not be null when sending a mission.

    public Mission createMission(List<Coordinate> missionPoints) {
        return assembledMission;
    }

    public void sendMission() {}

    public Mission changeMission(Mission oldMission, Mission mission, int strategyId) {return changedMission;}


}

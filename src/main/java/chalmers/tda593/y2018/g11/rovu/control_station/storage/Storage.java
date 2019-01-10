package chalmers.tda593.y2018.g11.rovu.control_station.storage;

import chalmers.tda593.y2018.g11.rovu.model.Environment;
import chalmers.tda593.y2018.g11.rovu.model.Mission;
import chalmers.tda593.y2018.g11.rovu.model.Status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Storage implements StatusDAO, MissionDAO, EnvironmentDAO, RewardDAO {

    private final Map<Integer, Status> robots = new HashMap<>();
    private final Map<Integer, Mission> missions = new HashMap<>();
    private int reward;
    private Environment map = new Environment(0, 0, null, null, null);

    @Override
    public synchronized void store(Mission mission) {
        missions.put(mission.getAssignedRobot(), mission);
    }

    @Override
    public synchronized Collection<Mission> getMissions() {
        return new ArrayList<>(missions.values());
    }

    @Override
    public Mission getMission(int assignedRobot) {
        return missions.get(assignedRobot);
    }

    @Override
    public int getReward() {
        return reward;
    }

    @Override
    public void addReward(int points) {
        reward += points;
    }

    @Override
    public void resetReward() {
        reward = 0;
    }

    @Override
    public void store(Status robot) {
        robots.put(robot.getId(), robot);
    }

    @Override
    public Status getStatus(int id) {
        return robots.get(id);
    }

    @Override
    public Collection<Status> getStatuses() {
        return new ArrayList<>(robots.values());
    }

    @Override
    public Collection<Integer> getRobotIds() {
        return new ArrayList<>(robots.keySet());
    }

    @Override
    public void store(Environment current) {
        map = current;
    }

    @Override
    public Environment getEnvironment() {
        return map;
    }
}

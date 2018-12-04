package control_station.storage;

import model.Environment;
import model.Mission;
import model.Status;

// TODO import model.Wall
import simbad.sim.Wall;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Storage implements StatusDAO, MissionDAO, EnvironmentDAO, RewardDAO {

    HashMap<Integer, Status> robots;
    HashSet<Mission> missions;
    int reward;
    Collection<Wall> map;

    @Override
    public void store(Mission mission) {
        missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return null;
    }

    @Override
    public Mission getMission(int assignedRobot) {
        return null;
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
        int id = 0; // TODO id = robot.id
        robots.put(id, robot);
    }

    @Override
    public Status getStatus(int id) {
        return robots.get(id);
    }

    @Override
    public Collection<Integer> getRobotIds() {
        return robots.keySet();
    }

    @Override
    public void store(Environment environment) {

    }

    @Override
    public Environment getEnvironment() {
        return null;
    }
}

package control_station.storage;

import model.Mission;
import model.Status;

// TODO import model.Wall
import simbad.sim.Wall;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Storage implements StatusDAO, MissionDAO, MapDAO, RewardDAO {

    HashMap<Integer, Status> robots;
    HashSet<Mission> missions;
    int reward;
    Collection<Wall> map;


    @Override
    public void add(Wall wall) {
        map.add(wall);
    }

    @Override
    public Collection<Wall> getWalls() {
        return map;
    }

    @Override
    public void store(Mission mission) {
        missions.add(mission);
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
}

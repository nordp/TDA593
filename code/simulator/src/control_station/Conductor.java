package control_station;

import control_station.strategizer.*;
import model.Coordinate;
import model.Mission;
import model.MovementInstruction;
import model.Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by svante on 2018-12-01.
 * The "brain" of the entire system.
 * Responsible for calculating optimal routes for robots, commands them when necessary
 */
class Conductor {
    private RobotInterface robotInterface;
    private Map<Strategy, Strategizer> strategies;

    Conductor(RobotInterface robotInterface){
        this.robotInterface = robotInterface;
        this.strategies = new HashMap<>();
        this.strategies.put(Strategy.SHORTEST_ROUTE, new ShortestPathStrategizer());
        this.strategies.put(Strategy.GIVEN_ORDER, new GivenOrderStrategizer());
        this.strategies.put(Strategy.BACKWARDS, new BackwardsStrategizer());
        this.strategies.put(Strategy.RANDOM, new StochasticStrategizer());
    }

    void setMission(Mission mission, Strategy strategy, int robot){
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
        return strategies.get(strategy).strategize(mission);
    }

    private void runMission(Mission mission, int id){

    }
}

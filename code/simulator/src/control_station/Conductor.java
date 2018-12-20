package control_station;

import control_station.strategizer.*;
import model.Coordinate;
import model.Mission;
import model.MovementInstruction;
import model.Strategy;
import control_station.storage.StorageBroker;
import model.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/**
 * Created by svante on 2018-12-01.
 * The "brain" of the entire system.
 * Responsible for calculating optimal routes for robots, commands them when necessary
 */
class Conductor implements Runnable {
    private RobotInterface robotInterface;
    private Map<Strategy, Strategizer> strategies;

    Conductor(RobotInterface robotInterface){
        this.robotInterface = robotInterface;
        this.strategies = new HashMap<>();
        this.strategies.put(Strategy.SHORTEST_ROUTE, new ShortestPathStrategizer());
        this.strategies.put(Strategy.GIVEN_ORDER, new GivenOrderStrategizer());
        this.strategies.put(Strategy.BACKWARDS, new BackwardsStrategizer());
        this.strategies.put(Strategy.RANDOM, new StochasticStrategizer());

        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    void setMission(Mission mission, Strategy strategy){
        //Is this used to store the current mission for a robot in the storage?
        //If so, this method should already exist in the storage package
        Mission strategized = strategize(mission, strategy);
        MovementInstruction moveCoor;
        List<Coordinate> missionList = strategized.getPoints();
        StorageBroker.getMissionDAO().store(mission);
        moveCoor = new MovementInstruction(true, missionList.get(0));

        robotInterface.dispatch(strategized.getAssignedRobot(), moveCoor);
    }

    private Mission strategize(Mission mission, Strategy strategy){
        return strategies.get(strategy).strategize(mission);
    }

    @Override
    public void run(){
        Collection<Integer> robotIds = StorageBroker.getStatusDAO().getRobotIds(); // Extract the ids from the storage.
        
        while(true){ // Main thread loop.
            for(Integer id : robotIds){
                try{
                    wait(10000);
                }catch(Exception e){}

                Mission mission = StorageBroker.getMissionDAO().getMission(id);
                Status status = StorageBroker.getStatusDAO().getStatus(id);

                if(mission != null && status != null && status.getLocation() != null) { // if robot has mission and we know the location of the robot
                    if (status.getLocation().equals(mission.getPoints().get(0))) {
                        // Remove the "to be sent" coordinate and store the rest of the mission back into the storage.
                       MovementInstruction move = new MovementInstruction(true, StorageBroker.getMissionDAO().getMission(id).getPoints().get(0));
                       List<Coordinate> cor = StorageBroker.getMissionDAO().getMission(id).getPoints();
                       cor.remove(0);
                       Mission m = new Mission(id, cor);
                       StorageBroker.getMissionDAO().store(m);

                       robotInterface.dispatch(id, move);
                    }
                }
            }
        }
    }
}
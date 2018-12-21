package chalmers.tda593.y2018.g11.rovu.control_station;

import chalmers.tda593.y2018.g11.rovu.control_station.storage.StorageBroker;
import chalmers.tda593.y2018.g11.rovu.model.*;

import java.util.Collection;
import java.util.List;


/**
 * Created by svante on 2018-12-01.
 * The "brain" of the entire system.
 * Responsible for calculating optimal routes for robots, commands them when necessary
 */
class Conductor implements Runnable {
    private RobotInterface robotInterface;

    Conductor(RobotInterface robotInterface){
        this.robotInterface = robotInterface;

        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    void setMission(Mission mission, Strategy strategy){
        //Is this used to store the current mission for a chalmers.tda593.y2018.g11.rovu.robot in the storage?
        //If so, this method should already exist in the storage package
        Mission strategized = Strategizer.strategize(strategy, mission);

        MovementInstruction move;
        List<Coordinate> missionList = strategized.getPoints();
        StorageBroker.getMissionDAO().store(mission);
        move = new MovementInstruction(true, missionList.get(0));

        robotInterface.dispatch(strategized.getAssignedRobot(), move);
    }

    @Override
    public void run(){
        Collection<Integer> robotIds = StorageBroker.getStatusDAO().getRobotIds(); // Extract the ids from the storage.

        while(true){ // Simulator thread loop.
            for(Integer id : robotIds){
                try{
                    wait(10000);
                }catch(Exception e){}

                Mission mission = StorageBroker.getMissionDAO().getMission(id);
                Status status = StorageBroker.getStatusDAO().getStatus(id);

                if(mission != null && status != null && status.getLocation() != null) { // if chalmers.tda593.y2018.g11.rovu.robot has mission and we know the location of the chalmers.tda593.y2018.g11.rovu.robot
                    if (status.getLocation().equals(mission.getPoints().get(0))) {
                        List<Coordinate> cor = StorageBroker.getMissionDAO().getMission(id).getPoints();

                        if (cor.size() > 1){
                            // Remove the "to be sent" coordinate and store the rest of the mission back into the storage.
                            MovementInstruction move = new MovementInstruction(true, cor.get(1));
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
}
package control_station;

import control_station.storage.StorageBroker;
import model.*;

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
        //Is this used to store the current mission for a robot in the storage?
        //If so, this method should already exist in the storage package
        Mission strategized = Strategizer.strategize(strategy, mission);

        MovementInstruction moveCoor;
        List<Coordinate> missionList = strategized.getPoints();
        StorageBroker.getMissionDAO().store(mission);
        moveCoor = new MovementInstruction(true, missionList.get(0));

        robotInterface.dispatch(strategized.getAssignedRobot(), moveCoor);
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
                        List<Coordinate> cor = StorageBroker.getMissionDAO().getMission(id).getPoints();
                        if (cor.size() > 1) {
                            MovementInstruction move = new MovementInstruction(true, StorageBroker.getMissionDAO().getMission(id).getPoints().get(1));
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
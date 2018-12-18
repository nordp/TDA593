package control_station;

import control_station.storage.StorageBroker;
import model.*;

import java.util.ArrayList;
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

    void setMission(Mission mission, Strategy strategy, int robot){
        //Is this used to store the current mission for a robot in the storage?
        //If so, this method should already exist in the storage package
        MovementInstruction moveCoor;
        List<Coordinate> missionList = mission.getPoints();

        StorageBroker.getMissionDAO().store(mission);

        /*int i = 0;
        while(i < missionList.size()){
            Status stat = store.getStatus(robot);
            if (stat.getLocation().equals(missionList.get(i)) || i == 0) {
                moveCoor = new MovementInstruction(true, missionList.get(i));
                robotInterface.dispatch(robot, moveCoor);
                i++;
            }
        }*/
           /* for(int i = 0; i < missionList.size(); i++) {
                    moveCoor = new MovementInstruction(true, missionList.get(i));
                    robotInterface.dispatch(robot, moveCoor);
            }*/

    }

    private Mission strategize(Mission mission, Strategy strategy){
        return null;
    }

    @Override
    public void run(){
        Collection<Integer> robotIds = StorageBroker.getStatusDAO().getRobotIds(); // Extract the ids from the storage.
        List<Integer> id = new ArrayList<>();
        robotIds.forEach (e -> id.add(e) ); // Extract the robot ids and make them accessible.
        while(true){ // Main thread loop.
            for(int i=0; i < id.size(); ){
              if(StorageBroker.getStatusDAO().getStatus(id.get(i)).getLocation() != null) {
                  if (StorageBroker.getStatusDAO().getStatus(id.get(i)).getLocation()
                          .equals(StorageBroker.getMissionDAO().getMission(id.get(i)).getPoints().get(0))) {
                      // Remove the "to be sent" coordinate and store the rest of the mission back into the storage.
                     Instruction move = new MovementInstruction(true, StorageBroker.getMissionDAO().getMission(id.get(i)).getPoints().get(0));
                     List<Coordinate> cor = StorageBroker.getMissionDAO().getMission(id.get(i)).getPoints();
                     cor.remove(0);
                     Mission m = new Mission(id.get(i), cor);
                     StorageBroker.getMissionDAO().store(m);

                     robotInterface.dispatch(id.get(i), move);
                  }
              }
            }
        }
    }
}

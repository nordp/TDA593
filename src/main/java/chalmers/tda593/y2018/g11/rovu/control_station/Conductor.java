package chalmers.tda593.y2018.g11.rovu.control_station;

import chalmers.tda593.y2018.g11.rovu.control_station.storage.StorageBroker;
import chalmers.tda593.y2018.g11.rovu.model.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by svante on 2018-12-01.
 * The "brain" of the entire system.
 * Responsible for calculating optimal routes for robots, commands them when necessary
 */
class Conductor implements Runnable {
    private RobotInterface robotInterface;
    private Map<Area,Integer> occupied;

    Conductor(RobotInterface robotInterface){
        this.robotInterface = robotInterface;

        this.occupied = new HashMap<>();

        for(Area area : StorageBroker.getMapDAO().getEnvironment().getPhysicalAreas()){
            occupied.put(area,0);
        }

        Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }

    void setMission(Mission mission, Strategy strategy){
        //Is this used to store the current mission for a robot in the storage?
        //If so, this method should already exist in the storage package
        Mission strategized = Strategizer.strategize(strategy, mission);
        StorageBroker.getMissionDAO().store(strategized);
    }

    @Override
    public void run(){

        while(true){ // Main thread loop.
            try{
                wait(100);
            }catch(Exception e){}


            for(Mission mission : StorageBroker.getMissionDAO().getMissions()){
                List<Coordinate> steps = mission.getPoints();

                if (steps.isEmpty()){
                    continue;
                } // No action to take

                Status assignee = StorageBroker.getStatusDAO().getStatus(mission.getAssignedRobot());

                Coordinate nextStep = steps.get(0);

                if (assignee.isInMotion()){
                    if (assignee.getLocation().equals(nextStep)){
                        steps.remove(0);
                        StorageBroker.getMissionDAO().store(new Mission(assignee.getId(),steps));
                        Status stopped = new Status(assignee.getId(),assignee.getLocation(),false,assignee.getInstructions(), assignee.getSensor(), assignee.getCamera());
                        StorageBroker.getStatusDAO().store(stopped);
                        robotInterface.dispatch(assignee.getId(), new StopInstruction(true));
                    }
                } else {
                    Area target = null;
                    for (Area physical : StorageBroker.getMapDAO().getEnvironment().getPhysicalAreas()) {
                        if (physical.isInArea(nextStep) ){
                            target = physical;
                        } else if (occupied.get(physical).equals(assignee.getId())){

                            // Leaving room -> wait 2 seconds
                            try  { Thread.sleep( 2000 ); }
                            catch (InterruptedException ie)  {}

                            // Wait 2 seconds before making room available
                            new Thread(() -> {
                                try  { Thread.sleep( 3000 ); }
                                catch (InterruptedException ie)  {}
                                occupied.put(physical,0);
                            }).start();
                        }
                    }

                    if (target == null || occupied.get(target).equals(0) || occupied.get(target).equals(assignee.getId())){
                        if (target != null){
                            occupied.replace(target,assignee.getId());
                        }
                        Status started = new Status(assignee.getId(),assignee.getLocation(),true,assignee.getInstructions(), assignee.getSensor(), assignee.getCamera());
                        StorageBroker.getStatusDAO().store(started);
                        robotInterface.dispatch(assignee.getId(), new StopInstruction(false));
                        robotInterface.dispatch(assignee.getId(), new MovementInstruction(true,nextStep));
                    }
                }
            }
        }
    }
}
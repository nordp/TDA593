package chalmers.tda593.y2018.g11.rovu.control_station;
//import chalmers.tda593.y2018.g11.rovu.model;
import chalmers.tda593.y2018.g11.rovu.control_station.storage.StatusDAO;
import chalmers.tda593.y2018.g11.rovu.control_station.storage.StorageBroker;
import chalmers.tda593.y2018.g11.rovu.model.Instruction;
import chalmers.tda593.y2018.g11.rovu.robot.ControlStationInterface;

import java.util.Map;

/**
 * Created by svante on 2018-12-01.
 * An interface between the control station and the robot.
 * Handles communication and between the two packages as
 * well as storing data comm
 * Currently missing a way to get information from robots
 */
class RobotInterface implements Runnable {

    private Map<Integer,ControlStationInterface> robots;
    //private RobotInterface instance; Might need to implement as a singleton, don't want more than one RobotInterface

    RobotInterface(Map<Integer, ControlStationInterface> robots){
        this.robots = robots;
        Thread t = new Thread(this);
        t.setDaemon(true);
        t.start();
    }

    /**
     * Param: id            - Control station interface? The key to a robot in the HashSet in Storage?
     *        Instruction   - Instruction needed to decide on a routine for a robot
     *
     * Dispatches an instruction to a robot with the identification 'id'
     */
    void dispatch(int id, Instruction instruction){
        robots.get(id).notify(instruction);
    }


    @Override
    public void run() {
        StatusDAO statusDAO = StorageBroker.getStatusDAO();
        while(true){
            for(ControlStationInterface robot : robots.values()){
                statusDAO.store(robot.getStatus());
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

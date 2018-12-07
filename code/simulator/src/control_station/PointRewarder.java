package control_station;
import control_station.storage.StorageBroker;
import model.Area;
import model.Status;

import java.util.Collection;

/**
 * Created by svante on 2018-12-01.
 */
public class PointRewarder implements Runnable {
    private Procedure current;
    private StorageBroker storageBroker;



    PointRewarder(){
        this.current = new ProcedureA(); //Defaulting to procedure A when initiating class, can be changed later
        this.storageBroker = new StorageBroker();
    }


    /**
     * Calculates and returns the amount of points that the current state of all robots
     * should reward depending on where in the environment they reside.
     */
    private int calculate(Collection<Status> robots, Collection<Area> areas) {


        return current.calculate(robots, areas);
    }

    private void updateStoragePoints(Collection<Status> robots, Collection<Area> areas){

        storageBroker.getRewardDAO().addReward(calculate(robots, areas));
    }

    /**
     * Calculates and adds points to the storage if the requirements are met.
     * Updates the current running procedure if the requirements are met.
     */
    @Override
    public void run() {
        try {
            Thread.sleep(20000);

            if(current instanceof ProcedureA) {
                updateStoragePoints(storageBroker.getStatusDAO().getStatuses(), storageBroker.getMapDAO().getEnvironment().getPhysicalAreas());
                current.update(storageBroker.getStatusDAO().getStatuses(), storageBroker.getMapDAO().getEnvironment().getLogicalAreas());
            } else {
                updateStoragePoints(storageBroker.getStatusDAO().getStatuses(), storageBroker.getMapDAO().getEnvironment().getLogicalAreas());
                current.update(storageBroker.getStatusDAO().getStatuses(), storageBroker.getMapDAO().getEnvironment().getPhysicalAreas());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

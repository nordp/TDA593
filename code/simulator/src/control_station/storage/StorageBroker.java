package control_station.storage;

public class StorageBroker {

    private static Storage store;

    public StorageBroker() {
        if (store == null) {
            store = new Storage();
        }
    }

    public StatusDAO getStatusDAO() {
        return store;
    }

    public MissionDAO getMissionDAO() {
        return store;
    }

    public EnvironmentDAO getMapDAO() {
        return store;
    }

    public RewardDAO getRewardDAO() {
        return store;
    }
}

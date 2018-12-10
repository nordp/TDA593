package control_station.storage;

public class StorageBroker {

    private static final Storage store = new Storage();

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

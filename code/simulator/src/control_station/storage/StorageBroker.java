package control_station.storage;

public class StorageBroker {

    private static final Storage store = new Storage();

    public static StatusDAO getStatusDAO() {
        return store;
    }

    public static MissionDAO getMissionDAO() {
        return store;
    }

    public static EnvironmentDAO getMapDAO() {
        return store;
    }

    public static RewardDAO getRewardDAO() {
        return store;
    }
}

package control_station.storage;

public interface RewardDAO {
    int getReward();
    void addReward(int points);
    void resetReward();
}

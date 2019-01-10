package chalmers.tda593.y2018.g11.rovu.control_station.storage;

public interface RewardDAO {
    int getReward();
    void addReward(int points);
    void resetReward();
}

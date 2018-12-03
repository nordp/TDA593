package control_station.storage;

public interface RewardDAO {
    public int getReward();
    public void addReward(int points);
    public void resetReward();
}

package control_station.strategizer;

import model.Mission;

public class GivenOrderStrategizer implements Strategizer {
    @Override
    public Mission strategize(Mission mission) {
        return mission;
    }
}

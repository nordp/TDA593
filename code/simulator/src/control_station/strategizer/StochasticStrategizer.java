package control_station.strategizer;

import model.Coordinate;
import model.Mission;

import java.util.Collections;
import java.util.List;

public class StochasticStrategizer implements Strategizer {
    @Override
    public Mission strategize(Mission mission) {
        List<Coordinate> points = mission.getPoints();
        Collections.shuffle(points);
        return new Mission(mission.getAssignedRobot(),points);
    }
}

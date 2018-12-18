package control_station.strategizer;

import model.Mission;
import model.Coordinate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackwardsStrategizer implements Strategizer {
    @Override
    public Mission strategize(Mission mission) {
        List<Coordinate> points = new ArrayList<>();
        Collections.reverse(points);
        return new Mission(mission.getAssignedRobot(), points);
    }
}

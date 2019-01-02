package chalmers.tda593.y2018.g11.rovu.control_station;

import chalmers.tda593.y2018.g11.rovu.model.Coordinate;
import chalmers.tda593.y2018.g11.rovu.model.Mission;
import chalmers.tda593.y2018.g11.rovu.model.Strategy;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class StrategyTest {

    private Coordinate c1 = new Coordinate(1,1);
    private Coordinate c2 = new Coordinate(2,2);
    private Coordinate c3 = new Coordinate(3,3);
    private Coordinate c4 = new Coordinate(4,4);

    @Test
    public void testStrategizer(){
        Strategy strategy1 = Strategy.GIVEN_ORDER;
        Strategy strategy2 = Strategy.BACKWARDS;
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(c1);
        coordinates.add(c2);
        coordinates.add(c3);
        coordinates.add(c4);

        Mission mission = new Mission(1,coordinates);
        Mission missiongiven = Strategizer.strategize(strategy1,mission);
        assertEquals(mission,missiongiven);

        Mission missionbackward = Strategizer.strategize(strategy2,mission);
        boolean isSameCoord = true;
        List<Coordinate> backwardcoordinates = missionbackward.getPoints();
        Collections.reverse(backwardcoordinates);
        for(int i = 0;i<backwardcoordinates.size();i++){
            if(!(backwardcoordinates.get(i).equals(coordinates.get(i)))){
                isSameCoord = false;
            }
        }

        assertTrue(isSameCoord);
    }
}

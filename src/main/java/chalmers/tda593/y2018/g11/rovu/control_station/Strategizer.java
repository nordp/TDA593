package chalmers.tda593.y2018.g11.rovu.control_station;

import chalmers.tda593.y2018.g11.rovu.model.Coordinate;
import chalmers.tda593.y2018.g11.rovu.model.Mission;
import chalmers.tda593.y2018.g11.rovu.model.Strategy;

import java.util.Collections;
import java.util.List;

public class Strategizer {
	private Strategizer() {}

     static Mission strategize(Strategy s, Mission m) {
		List<Coordinate> points;
    	switch (s) {
		    case GIVEN_ORDER:
				return m;
		    case RANDOM:
			    points = m.getPoints();
			    Collections.shuffle(points);
			    return new Mission(m.getAssignedRobot(),points);
		    case SHORTEST_ROUTE:
		    	throw new RuntimeException("Not implemented");
		    case BACKWARDS:
			    points = m.getPoints();
			    Collections.reverse(points);
			    return new Mission(m.getAssignedRobot(), points);
	        default: return m;
	    }
    }
}

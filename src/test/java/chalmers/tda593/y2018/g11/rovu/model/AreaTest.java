package chalmers.tda593.y2018.g11.rovu.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AreaTest {

    @Test
    public void containsCoordinate() {

        Area[] areas = {
		        new Area(new Coordinate(-1, -1), new Coordinate(1, 1), 0),
		        new Area(new Coordinate(1, -1), new Coordinate(-1, 1), 0),
		        new Area(new Coordinate(-1, 1), new Coordinate(1, -1), 0),
		        new Area(new Coordinate(1, 1), new Coordinate(-1, -1), 0),
        };

	    for (Area area: areas) {
		    assertFalse(area.isInArea(new Coordinate(-2, -2)));
		    assertFalse(area.isInArea(new Coordinate(2, -2)));
		    assertFalse(area.isInArea(new Coordinate(-2, 2)));
		    assertFalse(area.isInArea(new Coordinate(2, 2)));
		    assertFalse(area.isInArea(new Coordinate(0.5, 2)));
		    assertFalse(area.isInArea(new Coordinate(0.5, -2)));
		    assertFalse(area.isInArea(new Coordinate(-2, 0.5)));
		    assertFalse(area.isInArea(new Coordinate(2, 0.5)));

		    assertTrue(area.isInArea(new Coordinate(0, 0)));
		    assertTrue(area.isInArea(new Coordinate(0, 0.5)));
		    assertTrue(area.isInArea(new Coordinate(0, -0.5)));
		    assertTrue(area.isInArea(new Coordinate(0.5, 0)));
		    assertTrue(area.isInArea(new Coordinate(-0.5, 0)));


		    assertTrue(area.isInArea(new Coordinate(-0.5, 0.5)));
		    assertTrue(area.isInArea(new Coordinate(-0.5, -0.5)));
		    assertTrue(area.isInArea(new Coordinate(0.5, -0.5)));
		    assertTrue(area.isInArea(new Coordinate(0.5, 0.5)));
	    }

    }
}
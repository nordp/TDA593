package chalmers.tda593.y2018.g11.rovu.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoordinateTest {

    @Test
    public void equals() {

        Coordinate first = new Coordinate(1,2);
        Coordinate second = new Coordinate(2,3);
        Coordinate third = new Coordinate(1 - 0.000001 + Coordinate.MARGIN_OF_ERROR , 2 - 0.0000001 + Coordinate.MARGIN_OF_ERROR);
        assertFalse(first.equals(second));
        assertTrue(first.equals(first));
        assertTrue(first.equals(third));

    }
}
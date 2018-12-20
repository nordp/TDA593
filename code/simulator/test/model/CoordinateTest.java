package model;

import model.Coordinate;
import org.junit.Test;

import static org.junit.Assert.*;

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
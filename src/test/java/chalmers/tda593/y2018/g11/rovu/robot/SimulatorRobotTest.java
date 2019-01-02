package chalmers.tda593.y2018.g11.rovu.robot;

import chalmers.tda593.y2018.g11.rovu.model.Coordinate;
import org.junit.Test;
import project.Point;

import static org.junit.Assert.assertEquals;

public class SimulatorRobotTest {

    private Coordinate c0 = new Coordinate(0,0);
    private Coordinate c1 = new Coordinate(-3,-2);
    private Coordinate c2 = new Coordinate(4,1);
    private Coordinate c3 = new Coordinate(-5,0);
    private Coordinate c4 = new Coordinate(6,-4);
    private Coordinate c5 = new Coordinate(8,-8);
    private Coordinate c6 = new Coordinate(4,-3);
    private Coordinate c7 = new Coordinate(1,-5);

    private double offset = 8;


    @Test
    public void testCtoP(){
        assertEquals(c0, SimulatorRobot.pointToCoordinate(SimulatorRobot.coordinateToPoint(c0, offset, offset), offset, offset));
        assertEquals(c1, SimulatorRobot.pointToCoordinate(SimulatorRobot.coordinateToPoint(c1, offset, offset), offset, offset));
        assertEquals(c2, SimulatorRobot.pointToCoordinate(SimulatorRobot.coordinateToPoint(c2, offset, offset), offset, offset));
        assertEquals(c3, SimulatorRobot.pointToCoordinate(SimulatorRobot.coordinateToPoint(c3, offset, offset), offset, offset));
        assertEquals(c4, SimulatorRobot.pointToCoordinate(SimulatorRobot.coordinateToPoint(c4, offset, offset), offset, offset));
        assertEquals(c5, SimulatorRobot.pointToCoordinate(SimulatorRobot.coordinateToPoint(c5, offset, offset), offset, offset));
        assertEquals(c6, SimulatorRobot.pointToCoordinate(SimulatorRobot.coordinateToPoint(c6, offset, offset), offset, offset));
        assertEquals(c7, SimulatorRobot.pointToCoordinate(SimulatorRobot.coordinateToPoint(c7, offset, offset), offset, offset));

    }

}
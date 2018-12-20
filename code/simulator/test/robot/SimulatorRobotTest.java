package robot;

import model.Coordinate;
import org.junit.Test;
import project.Point;

import static org.junit.Assert.*;

public class SimulatorRobotTest {

    private Point point0 = new Point(0,0);
    private Point point1 = new Point(1,3);
    private Point point2 = new Point(4,2);
    private Point point3 = new Point(7,7);
    private Point point4 = new Point(2,3);
    private Point point5 = new Point(8,12);
    private Point point6 = new Point(2,14);
    private Point point7 = new Point(1,9);

    private Coordinate c0 = new Coordinate(0,0);
    private Coordinate c1 = new Coordinate(-3,-2);
    private Coordinate c2 = new Coordinate(4,1);
    private Coordinate c3 = new Coordinate(-5,0);
    private Coordinate c4 = new Coordinate(6,-4);
    private Coordinate c5 = new Coordinate(8,-8);
    private Coordinate c6 = new Coordinate(4,-3);
    private Coordinate c7 = new Coordinate(1,-5);

    SimulatorRobot simulatorRobot = new SimulatorRobot(new Point(2,2), "TestRobot");


    @Test
    public void testCtoP(){
        assertEquals(c0, simulatorRobot.pointToCoordinate(simulatorRobot.coordinateToPoint(c0)));
        assertEquals(c1, simulatorRobot.pointToCoordinate(simulatorRobot.coordinateToPoint(c1)));
        assertEquals(c2, simulatorRobot.pointToCoordinate(simulatorRobot.coordinateToPoint(c2)));
        assertEquals(c3, simulatorRobot.pointToCoordinate(simulatorRobot.coordinateToPoint(c3)));
        assertEquals(c4, simulatorRobot.pointToCoordinate(simulatorRobot.coordinateToPoint(c4)));
        assertEquals(c5, simulatorRobot.pointToCoordinate(simulatorRobot.coordinateToPoint(c5)));
        assertEquals(c6, simulatorRobot.pointToCoordinate(simulatorRobot.coordinateToPoint(c6)));
        assertEquals(c7, simulatorRobot.pointToCoordinate(simulatorRobot.coordinateToPoint(c7)));

    }

}
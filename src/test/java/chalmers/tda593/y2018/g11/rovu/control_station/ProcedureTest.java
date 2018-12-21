package chalmers.tda593.y2018.g11.rovu.control_station;

import chalmers.tda593.y2018.g11.rovu.model.Area;
import chalmers.tda593.y2018.g11.rovu.model.Coordinate;
import chalmers.tda593.y2018.g11.rovu.model.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ProcedureTest {

    ProcedureA a = new ProcedureA();
    ProcedureB b = new ProcedureB();

    private Coordinate c0 = new Coordinate(2,2);
    private Coordinate c1 = new Coordinate(6,6);
    private Coordinate c2 = new Coordinate(6,2);
    private Coordinate c3 = new Coordinate(2,6);
    private Coordinate c4 = new Coordinate(10, 2);

    Status s0 = new Status (0,  c0,  false, null, false, false);
    Status s1 = new Status (1,  c1,  false, null, false, false);
    Status s2 = new Status (2,  c2,  false, null, false, false);
    Status s3 = new Status (3,  c3,  false, null,false,false);
    Status s4 = new Status (4,  c4,  false, null,false,false);


    ArrayList<Status> statuses = new ArrayList<Status>();

    Collection<Area> physical = new ArrayList<>();

    Collection<Area> logical = new ArrayList<>();

    @Test
    public void testPointCounting(){

        int i = 0;

        statuses.add(s0);
        statuses.add(s1);
        statuses.add(s2);
        statuses.add(s3);
        statuses.add(s4);

        physical.add(new Area(new Coordinate(0, 0), new Coordinate(4, 4), 20)); // surgery 001
        physical.add(new Area(new Coordinate(4, 4), new Coordinate(8, 8), 20)); // surgery 002
        physical.add(new Area(new Coordinate(0, 4), new Coordinate(4, 8), 20)); // surgery 003
        physical.add(new Area(new Coordinate(4, 0), new Coordinate(8, 4), 20)); // surgery 004
        physical.add(new Area(new Coordinate(8, 0), new Coordinate(12, 4), 10)); // Consulting

        logical.add(new Area(new Coordinate(0, 0), new Coordinate(8, 8), 20)); // Eating area

        i += a.calculate(statuses, logical, physical);

        i += b.calculate(statuses, logical, physical);

        assertEquals(170, i);

    }

}
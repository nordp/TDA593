package cmd;
import control_station.ControlStationFactory;
import control_station.OperatorInterface;
import control_station.storage.StorageBroker;
import model.Area;
import model.Coordinate;
import model.Environment;
import model.Wall;
import project.AbstractSimulatorMonitor;
import project.Point;
import robot.ControlStationInterface;
import robot.RobotFactory;
import robot.SimulatorRobot;
import simbad.sim.*;
import user_interface.Display;
import user_interface.graphical_interface.MainWindow;

import java.awt.*;
import java.util.*;

@SuppressWarnings("unused")
public class Main {

	@SuppressWarnings("unused")
	public static void main(String... args) {
		boolean execute = true;
		if (args.length == 0) {
			System.out.printf("Please add an argument, in order to start the graphical, or the command-line user interface.%n" +
					"> cmd		start with command-line%n" +
					"> gui		start with gui%n" +
					"%n" +
					"Terminating now...%n"
			);
			execute = false;
		} else if (!(args[0].equals("gui") || (args[0].equals("cmd")))) {
			System.out.printf("Please add a valid argument, in order to start the graphical, or the command-line user interface.%n" +
					"> cmd		start with command-line%n" +
					"> gui		start with gui%n" +
					"%n" +
					"Terminating now...%n"
			);
		}

		if (execute) {
			EnvironmentDescription e = new EnvironmentDescription();

			// Set map
			Boundary w1 = new HorizontalBoundary(-8.0f, -8.0f, 8.0f, e, Color.MAGENTA);
			Boundary w2 = new HorizontalBoundary(8.0f, -8.0f, 8.0f, e, Color.MAGENTA);
			Boundary w3 = new VerticalBoundary(8.0f, -8.0f, 8.0f, e, Color.MAGENTA);
			Boundary w4 = new VerticalBoundary(-8.0f, -8.0f, 8.0f, e, Color.MAGENTA);


			Collection<Wall> walls = new ArrayList<>();

			// Consulting room
			AbstractWall roomWall11 = new HorizontalWall(-4f, -4f, -8f, e, Color.RED);
			walls.add(new Wall(new Coordinate(12, 4), new Coordinate(16, 4)));
			AbstractWall roomWall12 = new VerticalWall(-4f, -8f, -7f, e, Color.RED);
			walls.add(new Wall(new Coordinate(12, 1), new Coordinate(12, 0)));

			// Surgery rooms
			AbstractWall roomWall21 = new HorizontalWall(-4f, 4f, 8f, e, Color.BLUE);
			walls.add(new Wall(new Coordinate(0, 4), new Coordinate(4, 4)));
			AbstractWall roomWall22 = new HorizontalWall(0f, 4f, 8f, e, Color.BLUE);
			walls.add(new Wall(new Coordinate(0, 8), new Coordinate(4, 8)));
			AbstractWall roomWall23 = new HorizontalWall(4f, 4f, 8f, e, Color.BLUE);
			walls.add(new Wall(new Coordinate(0, 12), new Coordinate(4, 12)));

			AbstractWall roomWall24 = new VerticalWall(4f, -8f, -7f, e, Color.BLUE);
			walls.add(new Wall(new Coordinate(4, 0), new Coordinate(4, 1)));
			AbstractWall roomWall25 = new VerticalWall(4f, 8f, 7f, e, Color.BLUE);
			walls.add(new Wall(new Coordinate(4, 7), new Coordinate(4, 9)));
			AbstractWall roomWall26 = new VerticalWall(4f, -1f, 1f, e, Color.BLUE);
			walls.add(new Wall(new Coordinate(4, 15), new Coordinate(4, 16)));

			Collection<Area> physical = new ArrayList<>();
			physical.add(new Area(new Coordinate(0, 0), new Coordinate(4, 4), 20)); // surgery 001
			physical.add(new Area(new Coordinate(0, 4), new Coordinate(4, 8), 20)); // surgery 002
			physical.add(new Area(new Coordinate(0, 4), new Coordinate(4, 12), 20)); // surgery 003
			physical.add(new Area(new Coordinate(0, 4), new Coordinate(4, 16), 20)); // surgery 004
			physical.add(new Area(new Coordinate(12, 0), new Coordinate(16, 4), 10)); // Consulting
			Collection<Area> logical = new ArrayList<>();
			logical.add(new Area(new Coordinate(13, 13), new Coordinate(16, 16), 20)); // Eating area
			logical.add(new Area(new Coordinate(10, 0), new Coordinate(16, 10), 10)); // WIFI

			StorageBroker.getMapDAO().store(new Environment(16, 16, walls, logical, physical));

			// Create robots
			Set<SimulatorRobot> robots = new HashSet<>();
			Map<Integer, ControlStationInterface> controlStationInterfaces = new HashMap<>();


			SimulatorRobot robot1 = new SimulatorRobot(new Point(7, -7), "Robot 1");
			controlStationInterfaces.put(1,RobotFactory.build(1,robot1,robot1));
			robots.add(robot1);

			SimulatorRobot robot2 = new SimulatorRobot(new Point(7, -5), "Robot 2");
			controlStationInterfaces.put(2, RobotFactory.build(2, robot2, robot2));
			robots.add(robot2);

			SimulatorRobot robot3 = new SimulatorRobot(new Point(7, -3), "Robot 3");
			controlStationInterfaces.put(3, RobotFactory.build(3, robot3, robot3));
			robots.add(robot3);

			SimulatorRobot robot4 = new SimulatorRobot(new Point(7, -1), "Robot 4");
			controlStationInterfaces.put(4, RobotFactory.build(4, robot4, robot4));
			robots.add(robot4);

			// Set up the monitor
			AbstractSimulatorMonitor controller = new SimulatorMonitor(robots, e);
			OperatorInterface operatorInterface = ControlStationFactory.build(controlStationInterfaces);

			if(args[0].equals("gui")) {
				MainWindow.launch(MainWindow.class, args);
			}
			else{
				Display display = new Display(operatorInterface);
				display.displayView();
			}
		}
	}
}

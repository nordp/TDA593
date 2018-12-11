package cmd;
import control_station.ControlStationFactory;
import control_station.OperatorInterface;
import project.AbstractSimulatorMonitor;
import project.Point;
import robot.ControlStationInterface;
import robot.Controller;
import robot.SimulatorRobot;
import simbad.sim.*;
import user_interface.Display;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@SuppressWarnings("unused")
public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		EnvironmentDescription e = new EnvironmentDescription();
		
		Color color = Color.GRAY;

		// Set map
		Boundary w1 = new HorizontalBoundary(-5.0f, -5.0f, 5.0f, e, color);
		Boundary w2 = new HorizontalBoundary(5.0f, -5.0f, 5.0f, e, color);
		Boundary w3 = new VerticalBoundary(5.0f, -5.0f, 5.0f, e, color);
		Boundary w4 = new VerticalBoundary(-5.0f, -5.0f, 5.0f, e, color);

		// Build room
		AbstractWall roomWall1 = new HorizontalWall(-1f, 4.5f, 3.5f, e, color);
		AbstractWall roomWall2 = new HorizontalWall(-4.5f, 4.5f, 1f, e, color);
		AbstractWall roomWall3 = new VerticalWall(4.5f, -4.5f, -1f, e, color);
		AbstractWall roomWall4 = new VerticalWall(1f, -4.5f, -1f, e, color);

		// Create robots
		Set<SimulatorRobot> robots = new HashSet<>();
		Map<Integer,ControlStationInterface> controlStationInterfaces = new HashMap<>();


		SimulatorRobot robot1 = new SimulatorRobot(new Point(0, 0), "Robot 1");
		controlStationInterfaces.put(1, new ControlStationInterface(new Controller(robot1, robot1)));
		robots.add(robot1);


		SimulatorRobot robot2 = new SimulatorRobot(new Point(1, 3), "Robot 2");
		controlStationInterfaces.put(2, new ControlStationInterface(new Controller(robot2, robot2)));
		robots.add(robot2);

		// Set up the monitor

		AbstractSimulatorMonitor controller = new SimulatorMonitor(robots, e);
		OperatorInterface operatorInterface = ControlStationFactory.instanciate(controlStationInterfaces);


		//MainWindow.launch(MainWindow.class, args);
		Display display = new Display(operatorInterface);
		display.displayView();
	}

}

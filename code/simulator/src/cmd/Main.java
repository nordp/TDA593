package cmd;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import control_station.Conductor;
import control_station.OperatorInterface;
import control_station.RobotInterface;
import model.EmergencyInstruction;
import model.Instruction;
import model.MovementInstruction;
import project.AbstractRobotSimulator;
import project.Point;
import project.AbstractSimulatorMonitor;
import robot.ControlStationInterface;
import robot.Controller;
import robot.SimulatorRobot;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;
import user_interface.Display;

import java.awt.Color;
@SuppressWarnings("unused")
public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Instruction i = new EmergencyInstruction(true);

		System.out.println(i.equals(new EmergencyInstruction(true)));


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
		controlStationInterfaces.put(1 ,new Controller(robot1, robot1, null).controlStationInterface);
		robots.add(robot1);


		SimulatorRobot robot2 = new SimulatorRobot(new Point(1, 3), "Robot 2");
		controlStationInterfaces.put(2, new Controller(robot2, robot2, null).controlStationInterface);
		robots.add(robot2);

		// Set up the monitor
		AbstractSimulatorMonitor controller = new SimulatorMonitor(robots, e);

		Conductor conductor = new Conductor(controlStationInterfaces);

		Display display = new Display(conductor.operatorInterface);
		display.displayView();
	}

}

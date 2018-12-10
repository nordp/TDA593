package cmd;

import java.util.Set;

import project.AbstractSimulatorMonitor;
import robot.SimulatorRobot;
import simbad.sim.EnvironmentDescription;

public class SimulatorMonitor extends AbstractSimulatorMonitor<SimulatorRobot> {

	SimulatorMonitor(Set<SimulatorRobot> robots, EnvironmentDescription e) {
		super(robots, e);
	}

	

	@Override
	public void update(SimulatorRobot arg0) {
		//System.out.println(arg0.getName());
		//System.out.println(arg0.getPosition());
	}

}

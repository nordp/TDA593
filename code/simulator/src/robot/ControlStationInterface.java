package robot;

import control_station.RobotInterface;
import model.Instruction;
import model.Status;

public class ControlStationInterface {
	private RobotInterface controlStation;
	private Controller robot;

	ControlStationInterface (Controller robot, RobotInterface controlStation) {
		this.controlStation = controlStation;
		this.robot = robot;

		// Maybe signal the controlstation that we exists here?
	}

	public Status getStatus() {
		return this.robot.getStatus();
	}

	public void notify(Instruction instruction){
		this.robot.setInstruction(instruction);
	}
}

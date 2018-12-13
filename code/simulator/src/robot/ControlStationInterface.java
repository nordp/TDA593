package robot;

import model.Instruction;
import model.Status;

public class ControlStationInterface {
	private Controller robot;

	public ControlStationInterface (Controller robot) {
		this.robot = robot;
	}

	public Status getStatus() {
		return this.robot.getStatus();
	}

	public void notify(Instruction instruction){
		System.out.println("StationInterface");
		this.robot.setInstruction(instruction);
	}
}

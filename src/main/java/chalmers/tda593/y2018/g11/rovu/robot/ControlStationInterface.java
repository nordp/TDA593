package chalmers.tda593.y2018.g11.rovu.robot;

import chalmers.tda593.y2018.g11.rovu.model.Instruction;
import chalmers.tda593.y2018.g11.rovu.model.Status;

public class ControlStationInterface {
	private Controller robot;

	ControlStationInterface(Controller robot) {
		this.robot = robot;
	}

	public Status getStatus() {
		return this.robot.getStatus();
	}

	public void notify(Instruction instruction){
		this.robot.setInstruction(instruction);
	}
}

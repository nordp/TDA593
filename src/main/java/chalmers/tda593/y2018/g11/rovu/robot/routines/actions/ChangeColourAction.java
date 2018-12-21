package chalmers.tda593.y2018.g11.rovu.robot.routines.actions;

import chalmers.tda593.y2018.g11.rovu.robot.Actuator;

public class ChangeColourAction implements Action {
	@Override
	public void execute(Actuator actuator) {
		actuator.changeColour();
	}

	@Override
	public boolean blocking() {
		return false;
	}
}

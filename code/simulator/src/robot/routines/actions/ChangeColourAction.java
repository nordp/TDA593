package robot.routines.actions;

import robot.Actuator;

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

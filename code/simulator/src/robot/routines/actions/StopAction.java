package robot.routines.actions;

import robot.Actuator;

public class StopAction implements Action {
	@Override
	public void execute(Actuator actuator) {
		actuator.stop();
	}

	@Override
	public boolean blocking() {
		return true;
	}
}

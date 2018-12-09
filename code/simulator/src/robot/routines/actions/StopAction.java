package robot.routines.actions;

import robot.Actuator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

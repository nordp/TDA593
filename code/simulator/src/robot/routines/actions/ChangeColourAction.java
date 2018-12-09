package robot.routines.actions;

import robot.Actuator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

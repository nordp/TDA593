package robot.routines.actions;

import robot.Actuator;

public interface Action {
	void execute(Actuator actuator);
	boolean blocking();
}

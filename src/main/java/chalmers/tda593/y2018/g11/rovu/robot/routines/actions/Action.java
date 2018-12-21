package chalmers.tda593.y2018.g11.rovu.robot.routines.actions;

import chalmers.tda593.y2018.g11.rovu.robot.Actuator;

public interface Action {
	void execute(Actuator actuator);
	boolean blocking();
}

package chalmers.tda593.y2018.g11.rovu.robot.routines;

import chalmers.tda593.y2018.g11.rovu.model.Status;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.Action;

public interface Routine {
	Action calculateAction(Status status);
}

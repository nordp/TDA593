package chalmers.tda593.y2018.g11.rovu.robot.routines;

import chalmers.tda593.y2018.g11.rovu.model.ChangeColourInstruction;
import chalmers.tda593.y2018.g11.rovu.model.Status;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.Action;
import chalmers.tda593.y2018.g11.rovu.robot.routines.actions.ChangeColourAction;

import java.util.Calendar;
import java.util.Date;

public class ColourRoutine implements Routine {
	private Date lastRun = Calendar.getInstance().getTime();
	@Override
	public Action calculateAction(Status status) {
		Action a = null;
		ChangeColourInstruction i = (ChangeColourInstruction) status.getInstruction(ChangeColourInstruction.class);
		if (i != null && i.sent.after(lastRun)) {
			lastRun = i.sent;
			return new ChangeColourAction();
		}
		return null;
	}
}

package robot.routines;

import model.ChangeColourInstruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.ChangeColourAction;

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

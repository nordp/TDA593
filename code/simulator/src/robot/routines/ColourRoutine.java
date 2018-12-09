package robot.routines;

import model.ChangeColourInstruction;
import model.Instruction;
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
		for (Instruction i : status.getInstructions()) {
			if (i.equals(new ChangeColourInstruction())) {
				ChangeColourInstruction cci = (ChangeColourInstruction) i;
				if (cci.sent.after(lastRun)) {
					lastRun = cci.sent;
					a = new ChangeColourAction();
				}
			}
		}
		return a;
	}
}

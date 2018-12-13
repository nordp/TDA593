package robot.routines;

import model.Instruction;
import model.MovementInstruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.StopAction;

import java.util.Iterator;

public class MissionReachedRoutine implements Routine {
	//TODO Implement
	@Override
	public Action calculateAction(Status status) {
		Iterator<Instruction> iter = status.getInstructions().iterator();
		while (iter.hasNext()) {
			Instruction instr = iter.next();
			if (instr.equals(new MovementInstruction(true, null))) {
				MovementInstruction movement = (MovementInstruction) instr;
				if (movement.getNextStep().equals(status.getLocation())) {
					return new StopAction();
				}
			}
		}
		return null;
	}
}

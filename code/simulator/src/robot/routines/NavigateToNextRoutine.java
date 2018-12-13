package robot.routines;

import model.Instruction;
import model.MovementInstruction;
import model.Status;
import robot.routines.actions.Action;
import robot.routines.actions.MoveAction;

import java.util.Iterator;

public class NavigateToNextRoutine implements Routine {
	//TODO Implement
	@Override
	public Action calculateAction(Status status) {
		Iterator<Instruction> iterInstr = status.getInstructions().iterator();
		while(iterInstr.hasNext()){
			Instruction move = iterInstr.next();
			if(move.equals(new MovementInstruction(true, null))){
				MovementInstruction movement = (MovementInstruction)move;
				return new MoveAction(movement.getNextStep());
			}
		}
		return null;
	}
}

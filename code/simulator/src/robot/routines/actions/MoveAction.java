package robot.routines.actions;

import model.Coordinate;
import robot.Actuator;

public class MoveAction implements Action {
	private Coordinate coordinate;
	public MoveAction (Coordinate coordinate){
		this.coordinate = coordinate;
	}
	@Override
	public void execute(Actuator actuator) {
		System.out.println("GOGOGOG!!!");
		actuator.goTo(coordinate);
	}

	@Override
	public boolean blocking() {
		return true;
	}
}

package chalmers.tda593.y2018.g11.rovu.robot.routines.actions;

import chalmers.tda593.y2018.g11.rovu.model.Coordinate;
import chalmers.tda593.y2018.g11.rovu.robot.Actuator;

public class MoveAction implements Action {
	private Coordinate coordinate;
	public MoveAction (Coordinate coordinate){
		this.coordinate = coordinate;
	}
	@Override
	public void execute(Actuator actuator) {
		actuator.goTo(coordinate);
	}

	@Override
	public boolean blocking() {
		return true;
	}
}

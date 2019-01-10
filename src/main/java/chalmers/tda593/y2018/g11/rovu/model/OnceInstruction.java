package chalmers.tda593.y2018.g11.rovu.model;

import java.util.Calendar;
import java.util.Date;

public abstract class OnceInstruction extends Instruction {
	public final Date sent;

	OnceInstruction() {
		this.sent = Calendar.getInstance().getTime();
	}

}

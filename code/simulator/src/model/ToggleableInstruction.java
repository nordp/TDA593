package model;

public abstract class ToggleableInstruction extends Instruction {
	private final boolean active;

	ToggleableInstruction(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}
}

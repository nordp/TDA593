package model;

import java.util.Objects;

public abstract class ToggleableInstruction extends Instruction {
	private final boolean active;

	ToggleableInstruction(boolean active) {
		this.active = active;
	}

	public boolean getActive() {
		return active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		ToggleableInstruction that = (ToggleableInstruction) o;
		return active == that.active;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), active);
	}
}

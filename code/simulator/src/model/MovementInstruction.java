package model;

public class MovementInstruction extends Instruction {
    private final Coordinate nextStep;

    public MovementInstruction(boolean active, Coordinate nextStep){
    	super(active);
        this.nextStep = nextStep;
    }

    public Coordinate getNextStep() {
        return nextStep;
    }
}

package model;

public class MovementInstruction extends Instruction {
    private Coordinate nextStep;

    public MovementInstruction(Coordinate nextStep){
        this.nextStep = nextStep;
    }

    public MovementInstruction(){
        this.nextStep = new Coordinate();
    }

    public Coordinate getNextStep() {
        return nextStep;
    }

    public void setNextStep(Coordinate nextStep) {
        this.nextStep = nextStep;
    }
}

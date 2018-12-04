package model;

public class EmergencyInstruction extends Instruction {
    private boolean emergency;

    public EmergencyInstruction(boolean emergency) {
        this.emergency = emergency;
    }

    public EmergencyInstruction() {
        this.emergency = true;
    }

    public boolean getEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}



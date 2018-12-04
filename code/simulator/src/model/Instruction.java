package model;

public abstract class Instruction {
    // keep some sort of shared attributes b/w Movement- and EmergencyInstruction


    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass())){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}

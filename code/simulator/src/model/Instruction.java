package model;

public abstract class Instruction {

	/*
	* Equals implementation that only compares class name
	* This is important for the set of given instructions to work
	* By only allowing one active instruction of each type/class
	*/
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

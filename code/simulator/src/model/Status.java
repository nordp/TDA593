package model;

import java.util.HashSet;
import java.util.Set;

public class Status {
    private int id;
    private Coordinate location;
    private boolean inMotion;
    private Set<Instruction> instructions;

    public Status(){
        // TODO: default constructor
        this.instructions = new HashSet<>();
    }

    public Status(int id, Coordinate location, boolean inMotion, Set<Instruction> instructions){
        this.id = id;
        this.location = location;
        this.inMotion = inMotion;
        this.instructions = instructions;
    }

    public Coordinate getLocation() {
        return location;
    }

    public boolean isInMotion() {
        return inMotion;
    }

    public Set<Instruction> getInstructions() {
        return instructions;
    }

    public int getId() {
        return id;
    }
}

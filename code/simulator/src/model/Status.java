package model;

import java.util.HashSet;
import java.util.Set;

public class Status {
    private final int id;
    private final Coordinate location;
    private final boolean inMotion;
    private final Set<Instruction> instructions;

    public Status(int id, Coordinate location, boolean inMotion, Set<Instruction> instructions){
        this.id = id;
        this.location = location;
        this.inMotion = inMotion;
        this.instructions = instructions == null ? new HashSet<>() : new HashSet<>(instructions);
    }

    public Coordinate getLocation() {
        return location;
    }

    public boolean isInMotion() {
        return inMotion;
    }

    public Set<Instruction> getInstructions() {
        return new HashSet<>(instructions);
    }

    public int getId() {
        return id;
    }
}

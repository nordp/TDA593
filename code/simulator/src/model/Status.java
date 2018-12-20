package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Status {
    private final int id;
    private final Coordinate location;
    private final boolean inMotion;
    private final boolean sensorDetects;
    private final boolean cameraDetects;
    private final Map<Class, Instruction> instructions;

    public Status(int id, Coordinate location, boolean inMotion, Map<Class, Instruction> instructions, boolean sensorDetects, boolean cameraDetects){
        this.id = id;
        this.location = location;
        this.inMotion = inMotion;
        this.instructions = instructions == null ? new HashMap<>() : new HashMap<>(instructions);
        this.sensorDetects = sensorDetects;
        this.cameraDetects = cameraDetects;
    }

    public  boolean getCamera() { return this.cameraDetects; }

    public boolean getSensor() { return this.sensorDetects; }

    public Coordinate getLocation() {
        return location;
    }

    public boolean isInMotion() {
        return inMotion;
    }

    public Instruction getInstruction(Class c) {
        return instructions.get(c);
    }

	public Map<Class, Instruction> getInstructions() {
    	return new HashMap<>(this.instructions);
	}

    public int getId() {
        return id;
    }
}

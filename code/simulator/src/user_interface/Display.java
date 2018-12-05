package user_interface;
import control_station.OperatorInterface;
import model.EmergencyInstruction;
import model.Instruction;
import model.Mission;
import model.Coordinate;
import java.util.List;
import java.util.Scanner;

public class Display {
    private int points;
    private Scanner input = new Scanner(System.in);
    private List<Coordinate> missionList;
    private MissionComposer missionComp = new MissionComposer();
    private Mission mission;
    private OperatorInterface operatorInterface;

    public Display(OperatorInterface operatorInterface){
        this.operatorInterface = operatorInterface;
    }

    public void displayView(){
	    System.out.printf(
	    		"#######################################################################%n" +
			    "Program started! You can use this terminal to control your robots.%n" +
			    "See \"help\" for available commands%n" +
			    "\"exit\" to quit program. %n")
	    ;
	    System.out.printf("\"exit\" to quit program. %n");
    	while (true) {
    		System.out.printf("> ");
		    String[] parts = input.nextLine().split(" ");
		    if (parts.length > 0 && "exit".equals(parts[0])) {
			    System.exit(0);
		    } else if (parts.length > 0 && "stop".equals(parts[0])) {
		    	if (parts.length > 1) {

				    // Todo handle invalid id
		    		int robot = Integer.parseInt(parts[1]);
				    System.out.printf("Stopping robot %s%n", robot);
				    operatorInterface.assignAction(robot, new EmergencyInstruction(true));
			    } else {
				    System.out.printf("Stopping all robots %n");
				    // TODO stop all robots
			    }
		    } else if (parts.length > 0 && "start".equals(parts[0])) {
			    if (parts.length > 1) {
			    	// Todo handle invalid id
				    int robot = Integer.parseInt(parts[1]);
				    System.out.printf("Starting robot %s%n", robot);
				    operatorInterface.assignAction(robot, new EmergencyInstruction(false));
			    } else {
				    System.out.printf("Starting all robots%n");
				    // TODO start all robots
			    }
		    } else if (parts.length > 1 && "robot".equals(parts[0])) {

			    // Todo handle invalid id
		    	int robot = Integer.parseInt(parts[1]);

			    System.out.printf("Robot %s selected, \"q\" to deselect%n", robot);
		    	while (true) {
				    System.out.printf("Robot %s > ", robot);
				    parts = input.nextLine().split(" ");
				    if (parts.length > 0 && "q".equals(parts[0])) {
				    	break;
				    } else if (parts.length > 0 && "stop".equals(parts[0])) {
					    System.out.printf("Stopping robot %s%n", robot);
					    operatorInterface.assignAction(robot, new EmergencyInstruction(true));
				    } else if (parts.length > 0 && "start".equals(parts[0])) {
					    System.out.printf("Starting robot %s%n", robot);
					    operatorInterface.assignAction(robot, new EmergencyInstruction(false));
				    } else if (parts.length > 0 && "mission".equals(parts[0])) {
				    	// TODO parse mission
				    } else if (parts.length > 0 && "exit".equals(parts[0])) {
					    System.exit(0);
				    } else if (parts.length > 0 && "help".equals(parts[0])) {
				    	String[] commands = {
				    			"exit                                   - Quits application",
							    "stop                                   - Stops the robot",
							    "start                                  - Starts the robot",
							    "mission {strategy} {1,5 4,8 points...} - Sets a mission for the robot",
							    "map                                    - show the current map",
							    "q                                      - deselect the robot",
							    "help                                   - show this help text",
				    	};
					    System.out.printf(String.join("%n", commands) + "%n");
				    } else if (parts.length > 0 && "map".equals(parts[0])) {
				    	// TODO print map
				    } else {
					    System.out.printf("Input wasn't recognized see \"help\" for available commands %n");
				    }
			    }
		    } else if (parts.length > 0 && "help".equals(parts[0])) {
			    String[] commands = {
					    "exit                 - Quits application",
					    "stop                 - Stops all robots",
					    "stop  {robotId}      - Stops the robot",
					    "start                - Starts all robots",
					    "start {robotId}      - Starts the robot",
					    "robot {robotId}      - selects the robot",
					    "robots               - get info about available robots",
					    "map                  - show the current map",
					    "help                 - show this help text",
			    };
			    System.out.printf(String.join("%n", commands) + "%n");
		    } else if (parts.length > 0 && "map".equals(parts[0])) {
			    // TODO print map
		    } else if (parts.length > 0 && "robots".equals(parts[0])) {
			    // TODO print robots info
		    } else {
			    System.out.printf("Input wasn't recognized see \"help\" for available commands %n");
		    }
	    }

    }

    public void updateView(){}

}

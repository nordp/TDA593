package user_interface;
import control_station.OperatorInterface;
import model.*;

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
			    "\"exit\" to quit program. %n");
    	while (true) {
    		System.out.printf("> ");
		    String[] parts = input.nextLine().split(" ");

		    if(parts.length > 1){
		    	int robot = Integer.parseInt(parts[1]);
		    	switch (parts[0]){
					case "start":
						// Todo handle invalid id
						System.out.printf("Starting robot %s%n", robot);
						operatorInterface.assignAction(robot, new EmergencyInstruction(false));
						break;
					case "stop":
						// Todo handle invalid id
						System.out.printf("Stopping robot %s%n", robot);
						operatorInterface.assignAction(robot, new EmergencyInstruction(true));
						break;
					case "robot":
						// Todo handle invalid id
						System.out.printf("Robot %s selected, \"q\" to deselect%n", robot);
						while (true) {
							System.out.printf("Robot %s > ", robot);
							parts = input.nextLine().split(" ");

							if (parts.length > 0) {
								switch (parts[0]) {
									case "start":
										System.out.printf("Starting robot %s%n", robot);
										operatorInterface.assignAction(robot, new EmergencyInstruction(false));
										break;
									case "stop":
										System.out.printf("Stopping robot %s%n", robot);
										operatorInterface.assignAction(robot, new EmergencyInstruction(true));
										break;
									case "color":
									case "colour":
										System.out.printf("Changing colo(u)r of robot %s%n", robot);
										operatorInterface.assignAction(robot, new ChangeColourInstruction());
										break;
									case "mission":
										//TODO: parse mission
										break;
									case "exit":
										System.exit(0);
										break;
									case "help":
										String[] commands = {
												"exit                                   - Quits application",
												"stop                                   - Stops the robot",
												"start                                  - Starts the robot",
												"mission {strategy} {1,5 4,8 points...} - Sets a mission for the robot",
												"map                                    - show the current map",
												"q                                      - deselect the robot",
												"help                                   - show this help text",
												"colour || color                        - makes the robot change colo(u)r",
										};
										System.out.printf(String.join("%n", commands) + "%n");
										break;
									case "q":
										break;
									default:
										System.out.printf("Input wasn't recognized see \"help\" for available commands %n");
								}

								if (parts[0].equals("q"))
									break;
								
							} else {
								System.out.printf("Input wasn't recognized see \"help\" for available commands %n");
							}
						}
				}
			}
		    else if(parts.length > 0){
				switch (parts[0]){
					case "start":
						System.out.printf("Starting all robots%n");
						// TODO start all robots
						break;
					case "stop":
						System.out.printf("Stopping all robots %n");
						// TODO stop all robots
						break;
					case "map":
						//TODO: print map?
						break;
					case "exit":
						System.exit(0);
						break;
					case "help":
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
						break;
					case "robots":
						//TODO: print robots info
						break;
					default:
						System.out.printf("Input wasn't recognized see \"help\" for available commands %n");
				}
			}

	    }

    }

    public void updateView(){}

}

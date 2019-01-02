package chalmers.tda593.y2018.g11.rovu.user_interface.cmd;

import chalmers.tda593.y2018.g11.rovu.control_station.OperatorInterface;
import chalmers.tda593.y2018.g11.rovu.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Display {
    private int points;
    private Scanner input = new Scanner(System.in);
    private List<Coordinate> missionList = new ArrayList<>();
    private MissionComposer missionComp = new MissionComposer();
    private Mission mission;
    private OperatorInterface operatorInterface;
    private MapPlotter plotter;

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
		    	if(!(checkIfValid(robot))){
					System.out.printf("Robot with id %s does not exists! Try again!%n",robot);
				}
				else {
					switch (parts[0]) {
						case "start":
							System.out.printf("Starting robot %s%n", robot);
							operatorInterface.assignAction(robot, new StopInstruction(false));
							break;
						case "stop":
							System.out.printf("Stopping robot %s%n", robot);
							operatorInterface.assignAction(robot, new StopInstruction(true));
							break;
						case "robot":
							System.out.printf("Robot %s selected, \"q\" to deselect%n", robot);
							while (true) {
								System.out.printf("Robot %s > ", robot);
								parts = input.nextLine().split(" ");

								if (parts.length > 0) {
									switch (parts[0]) {
										case "start":
											System.out.printf("Starting robot %s%n", robot);
											operatorInterface.assignAction(robot, new StopInstruction(false));
											break;
										case "stop":
											System.out.printf("Stopping robot %s%n", robot);
											operatorInterface.assignAction(robot, new StopInstruction(true));
											break;
										case "color":
										case "colour":
											System.out.printf("Changing colo(u)r of robot %s%n", robot);
											operatorInterface.assignAction(robot, new ChangeColourInstruction());
											break;
										case "mission":
											System.out.println("Add a coordinate within the allowed range.");
											System.out.println("Write 'done' when all desired mission points are input.");

											Strategy choice = Strategy.GIVEN_ORDER;
											if (parts.length > 1) {
												switch (parts[1]) {
													case "shortest":
														choice = Strategy.SHORTEST_ROUTE;
														break;
													case "given":
														choice = Strategy.GIVEN_ORDER;
														break;
													case "backwards":
														choice = Strategy.BACKWARDS;
														break;
													case "random":
														choice = Strategy.RANDOM;
														break;
												}
											}

											double inputX;
											double inputY;
											String cont = "";

											while (!(cont.equals("no"))) {
												System.out.println("Enter coordinates one after the other"); // Shorten down to use float array.
												System.out.printf("> ");
												inputX = input.nextDouble();
												System.out.printf("> ");
												inputY = input.nextDouble();
												missionList.add(new Coordinate(inputX, inputY));
												System.out.print("Continue input? (yes/no)");
												System.out.printf("> ");
												input.nextLine();
												cont = input.nextLine();
											}
											mission = missionComp.createMission(missionList, robot);
											operatorInterface.assignMission(mission, choice);
											missionList.clear();
											break;
										case "exit":
											System.exit(0);
											break;
										case "help":
											String[] commands = {
													"exit                                   - Quits application",
													"stop                                   - Stops the robot",
													"start                                  - Starts the robot",
													"mission {shortest|backwards|random}    - Sets a mission for the robot",
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
			}
		    else if(parts.length > 0){
				switch (parts[0]){
					case "start":
						System.out.printf("Starting all robots%n");
						operatorInterface.getStatuses().forEach((Status status) -> {
							operatorInterface.assignAction(status.getId(), new StopInstruction(false));
						});
						break;
					case "stop":
						System.out.printf("Stopping all robots %n");
						operatorInterface.getStatuses().forEach((Status status) -> {
							operatorInterface.assignAction(status.getId(), new StopInstruction(true));
						});
						break;
					case "map":
						System.out.println("# - Wall");
						System.out.println("^ - Physical area ");
						System.out.println("* - Logical area");
						System.out.println("¨ - Both Physical and Logical area");
						plotter = new MapPlotter(operatorInterface);
						break;
					case "points":
						printPoints();
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
								"points               - show the total amount of points rewarded",
								"help                 - show this help text",
						};
						System.out.printf(String.join("%n", commands) + "%n");
						break;
					case "robots":
						operatorInterface.getStatuses().forEach((Status status) -> {
							System.out.printf("%d: (%d, %d)%n", status.getId(), (int) status.getLocation().getX(), (int) status.getLocation().getY());
						});
						break;
					default:
						System.out.printf("Input wasn't recognized see \"help\" for available commands %n");
				}
			}
	    }
    }

    private void printPoints(){
    	int reward = operatorInterface.getRewardPoints();
		System.out.println("The current total amount of points rewarded: " + reward);
	}


	private boolean checkIfValid(int robot){
		Collection<Status> robots= operatorInterface.getStatuses();
		for(Status s : robots){
			if(s.getId() == robot){
				return true;
			}

		}
		return false;
	}
}

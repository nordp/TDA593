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

        while(!input.equals(5)){
            // Simple UI draw.
            System.out.println("****WELCOME TO ROVU!******");
            System.out.println("Current points: " + points);
            System.out.println("Please choose an option to perform:");
            System.out.println("1 - Create a Mission");
            System.out.println("2 - Change a Mission");
            System.out.println("3 - Assign an action");
            System.out.println("4 - Update interface");
            System.out.println("**************************");
            // Options go here
            switch(input.nextInt()){

                case 1:

                    break;

                case 2:

                    break;

                case 3:
                    System.out.println("1 - Emergency Stop");
                    System.out.println("PLACEHOLDER");
                    switch (input.nextInt()){
                        case 1:
                        System.out.println("Choose which robot you want to assign this action to");
                        operatorInterface.assignAction(input.nextInt(),new EmergencyInstruction(true));
                    }

                    break;

                case 4:

                    break;

                default :

            }

        }

    }

    public void updateView(){}

}

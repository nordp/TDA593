package user_interface;
import model.Mission;
import model.Coordinate;
import java.util.List;
import java.util.Scanner;

public class Display {
    private int points;
    private Action action = new Action();
    private Scanner input = new Scanner(System.in);
    private List<Coordinate> missionList;
    private MissionComposer missionComp = new MissionComposer();
    private Mission mission;

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

                    break;

                case 4:

                    break;

                default :

            }

        }

    }

    public void updateView(){}

}

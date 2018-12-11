package cmd;

import control_station.Conductor;
import control_station.OperatorInterface;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import project.AbstractSimulatorMonitor;
import project.Point;
import robot.ControlStationInterface;
import robot.Controller;
import robot.SimulatorRobot;
import simbad.sim.*;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainWindow extends Application {

    static Conductor conductor;

    public static void main(String[] args) {
        EnvironmentDescription e = new EnvironmentDescription();

        Color color = Color.GRAY;

        // Set map
        Boundary w1 = new HorizontalBoundary(-5.0f, -5.0f, 5.0f, e, color);
        Boundary w2 = new HorizontalBoundary(5.0f, -5.0f, 5.0f, e, color);
        Boundary w3 = new VerticalBoundary(5.0f, -5.0f, 5.0f, e, color);
        Boundary w4 = new VerticalBoundary(-5.0f, -5.0f, 5.0f, e, color);

        // Build room
        AbstractWall roomWall1 = new HorizontalWall(-1f, 4.5f, 3.5f, e, color);
        AbstractWall roomWall2 = new HorizontalWall(-4.5f, 4.5f, 1f, e, color);
        AbstractWall roomWall3 = new VerticalWall(4.5f, -4.5f, -1f, e, color);
        AbstractWall roomWall4 = new VerticalWall(1f, -4.5f, -1f, e, color);

        // Create robots
        Set<SimulatorRobot> robots = new HashSet<>();
        Map<Integer, ControlStationInterface> controlStationInterfaces = new HashMap<>();


        SimulatorRobot robot1 = new SimulatorRobot(new project.Point(0, 0), "Robot 1");
        controlStationInterfaces.put(1 ,new Controller(robot1, robot1, null).controlStationInterface);
        robots.add(robot1);


        SimulatorRobot robot2 = new SimulatorRobot(new Point(1, 3), "Robot 2");
        controlStationInterfaces.put(2, new Controller(robot2, robot2, null).controlStationInterface);
        robots.add(robot2);

        // Set up the monitor
        AbstractSimulatorMonitor controller = new SimulatorMonitor(robots, e);

        conductor = new Conductor(controlStationInterfaces);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Robot Simulator GUI");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label label0 = new Label("Current robot:");
        GridPane.setHalignment(label0, HPos.RIGHT);
        grid.add(label0, 1, 0);

        //FIXME: this is hardcoded since we don't have Storage implemented yet
        ObservableList<String> robots =
                FXCollections.observableArrayList(
                        "Robot 1",
                        "Robot 2"
                );
        ComboBox robotsComboBox = new ComboBox(robots);
        grid.add(robotsComboBox, 2, 0);

        Label label1 = new Label("Current points:  ");
        GridPane.setHalignment(label1, HPos.RIGHT);
        grid.add(label1, 1, 1);

        Label points = new Label("0");
        grid.add(points, 2,1);


        // mission selection combobox
        ObservableList<String> missions =
                FXCollections.observableArrayList(
                        "Given order",
                        "Shortest route",
                        "Backwards order",
                        "Random"
                );
        ComboBox missionComboBox = new ComboBox(missions);
        grid.add(missionComboBox, 1, 2);

        Button button = new Button("GO!");
        button.setDefaultButton(true);
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(button.getText()=="GO!"){
                    button.setText("STOP!");
                    missionComboBox.setVisible(false);
                }
                else{
                    button.setText("GO!");
                    missionComboBox.setVisible(true);
                }
            }
        });
        grid.add(button, 2, 2);

        //TODO: add change colour functionality/robots simulation
        Button changeColorBtn = new Button("Change Colour");
        grid.add(changeColorBtn,2,3);
        changeColorBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //FIXME: shouldnt be hardcoded
                int robot = Integer.parseInt(robotsComboBox.getValue().toString().substring(6));
                System.out.println(robot);

            }
        });


        Scene scene = new Scene(grid, 400, 275);
        primaryStage.setScene(scene);


        primaryStage.show();
    }
}

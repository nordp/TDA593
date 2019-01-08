package chalmers.tda593.y2018.g11.rovu.user_interface.graphical;

import chalmers.tda593.y2018.g11.rovu.model.Strategy;
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

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainWindow extends Application {


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
                        Stream.of(Strategy.values())
                                .map(Enum::name)
                                .collect(Collectors.toList())
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

                    //FIXME: shouldnt be hardcoded
                    int robot = Integer.parseInt(robotsComboBox.getValue().toString().substring(6));
                    System.out.println("Starting Robot #"+robot);
                }
                else{
                    button.setText("GO!");
                    missionComboBox.setVisible(true);

                    //FIXME: shouldnt be hardcoded
                    int robot = Integer.parseInt(robotsComboBox.getValue().toString().substring(6));
                    System.out.println("Stopping Robot #"+robot);
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

            }
        });


        Scene scene = new Scene(grid, 400, 275);
        primaryStage.setScene(scene);


        primaryStage.show();
    }
}
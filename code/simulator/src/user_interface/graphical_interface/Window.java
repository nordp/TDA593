package user_interface.graphical_interface;

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

public class Window extends Application {

    public static void main(String[] args) {
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
                    System.out.println(missionComboBox.getValue());
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


        Scene scene = new Scene(grid, 400, 275);
        primaryStage.setScene(scene);


        primaryStage.show();
    }
}

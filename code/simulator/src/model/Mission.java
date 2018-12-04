package model;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private List<Coordinate> missionPoints;

    public Mission(){
        //FIXME: ok how is arraylist is it ok
        this.missionPoints = new ArrayList<Coordinate>();
    }

    public Mission(List<Coordinate> missionPoints){
        this.missionPoints = missionPoints;
    }

    public List<Coordinate> getPoints() {
        return missionPoints;
    }

    public void addPoint(Coordinate point){
        this.missionPoints.add(point);
    }
}

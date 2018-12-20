package user_interface;

import control_station.OperatorInterface;
import model.Coordinate;
import model.Environment;
import model.Status;
import model.Wall;

import java.util.Collection;

public class MapPlotter {
    private OperatorInterface operatorInterface;
    private char[][] plot;
    private Collection<Wall> walls;
    private int width;
    private int height;
    private Collection<Status> robots;
    private static final int RESOLUTION = 4;

    public MapPlotter(OperatorInterface operatorInterface){
        this.operatorInterface = operatorInterface;
        Environment map = operatorInterface.getEnv();
        width = (int)map.getWidth();
        height = (int)map.getHeight();
        plot = new char[width*RESOLUTION][height*RESOLUTION];
        walls = map.getWalls();
        robots = operatorInterface.getStatuses();
        addWalls();
        addRobots();
        printMap();
    }

    private void addWalls(){
        for(Wall w : walls){
            Coordinate start = w.getStart();
            Coordinate end = w.getEnd();
            int startX = (int)(start.getX() < end.getX() ? start.getX() : end.getX());
            int startY = (int)(start.getY() < end.getY() ? start.getY() : end.getY());
            int endX = (int)(start.getX() >= end.getX() ? start.getX() : end.getX());
            int endY = (int)(start.getY() >= end.getY() ? start.getY() : end.getY());

            if (startX == endX) {
                for(int j = startY * RESOLUTION; j < endY * RESOLUTION; j++){
                    plot[startX * RESOLUTION][j] = '#';
                }
            } else if (startY == endY) {
                for(int i = startX * RESOLUTION; i < endX * RESOLUTION; i++){
                    plot[i][startY * RESOLUTION] = '#';
                }
            } else {
                for(int i = startX * RESOLUTION; i < endX * RESOLUTION; i++){
                    for(int j = startY * RESOLUTION; j < endY * RESOLUTION; j++){
                        plot[i][j] = '#';
                    }
                }
            }
        }
    }

    private void addRobots(){
        for(Status s : robots){
            Coordinate location = s.getLocation();
            int x, y;
            x = (int) s.getLocation().getX();
            y = (int) s.getLocation().getY();
            plot[x * RESOLUTION][y * RESOLUTION] = Integer.toString(s.getId() % 10).charAt(0);
        }
    }

    private void printMap(){
        for (int i = -2; i < width * RESOLUTION;i++) System.out.print("#");
        System.out.println();

        for(int i = 0; i < plot[0].length;i++){
            System.out.print("#");
            for(int j = 0; j < plot.length;j++){
                if(plot[j][i] == 0){
                    System.out.print(' ');
                }
                else{
                    System.out.print(plot[j][i]);
                }
            }
            System.out.println("#");
        }
        for (int i = -2; i < width * RESOLUTION;i++) System.out.print("#");
        System.out.println();
    }


}

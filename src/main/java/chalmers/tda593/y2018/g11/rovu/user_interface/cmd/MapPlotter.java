package chalmers.tda593.y2018.g11.rovu.user_interface.cmd;

import chalmers.tda593.y2018.g11.rovu.control_station.OperatorInterface;
import chalmers.tda593.y2018.g11.rovu.model.*;

import java.util.Collection;
import java.util.function.Function;

public class MapPlotter {
    private OperatorInterface operatorInterface;
    private char[][] plot;
    private Collection<Wall> walls;
    private Collection<Area> logicalAreas;
    private Collection<Area> physicalAreas;
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
        logicalAreas = map.getLogicalAreas();
        physicalAreas = map.getPhysicalAreas();
        addAreaPhysical();
        addAreaLogical();
        addWalls();
        addRobots();
        printMap();
    }

    private void addAreaLogical(){
        for(Area a : logicalAreas){
            Coordinate start = a.getA();
            Coordinate end = a.getB();
            addArea(start,end,(character -> {
                if(character.equals('^')){
                    return '¨';
                }
                else {
                    return '*';
                }
            }));
        }
    }

    private void addAreaPhysical(){
        for(Area a : physicalAreas){
            Coordinate start = a.getA();
            Coordinate end = a.getB();
            addArea(start,end,(character -> '^'));
        }
    }

    private void addArea(Coordinate start,Coordinate end, Function<Character, Character> symbolChooser){
        int startX = (int)(start.getX() < end.getX() ? start.getX() : end.getX());
        int startY = (int)(start.getY() < end.getY() ? start.getY() : end.getY());
        int endX = (int)(start.getX() >= end.getX() ? start.getX() : end.getX());
        int endY = (int)(start.getY() >= end.getY() ? start.getY() : end.getY());

        if (startX == endX) {
            for(int j = startY * RESOLUTION; j < endY * RESOLUTION; j++){
                plot[startX * RESOLUTION][j] = symbolChooser.apply(plot[startX * RESOLUTION][j]);
            }
        } else if (startY == endY) {
            for(int i = startX * RESOLUTION; i < endX * RESOLUTION; i++){
                plot[i][startY * RESOLUTION] = symbolChooser.apply(plot[i][startY * RESOLUTION]);
            }
        } else {
            for(int i = startX * RESOLUTION; i < endX * RESOLUTION; i++){
                for(int j = startY * RESOLUTION; j < endY * RESOLUTION; j++){
                    plot[i][j] = symbolChooser.apply(plot[i][j]);
                }
            }
        }
    }



    private void addWalls(){
        for(Wall w : walls){
            Coordinate start = w.getStart();
            Coordinate end = w.getEnd();
            addArea(start,end,(character -> '#'));
        }
    }

    private void addRobots(){
        for(Status s : robots){
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

package de.itemis.manhattendistance;

public class Point {
    final private int xCoordinate;
    final private int yCoordinate;

    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int distanceTo(Point p2) {
        return Math.abs(xCoordinate - p2.xCoordinate) + Math.abs(yCoordinate - p2.yCoordinate);
    }
}

package de.itemis.manhattendistance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ObjectArrayArguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ManhattanDistanceTest {

    static Stream<Arguments> intArguments() {
        return Stream.of(
                ObjectArrayArguments.create(1, 1, 2, 2, 2),
                ObjectArrayArguments.create(1, 1, 1, 1, 0)
        );
    }

    static Stream<Arguments> classArguments() {
        return Stream.of(
                ObjectArrayArguments.create(new Point(1, 1), new Point(2, 2), 2),
                ObjectArrayArguments.create(new Point(2, 2), new Point(5, 7), 8)
        );
    }


    // Inspired by http://code-mentor.com/blog/2017/junit5-parameterized-tests.html
    @ParameterizedTest
    @DisplayName("Test Distance with Integer")
    @MethodSource(names = "intArguments")
    void distanceCalculation(int x1, int y1, int x2, int y2, int expected) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        ManhattanDistance manhattanDistance = new ManhattanDistance();

        assertEquals(expected, manhattanDistance.measureDistance(p1, p2));
    }

    @ParameterizedTest
    @DisplayName("Test Distance with Point objects")
    @MethodSource(names = "classArguments")
    void distanceCalculation(Point p1, Point p2, int expected) {
        ManhattanDistance manhattanDistance = new ManhattanDistance();

        assertEquals(expected, manhattanDistance.measureDistance(p1, p2));
    }

    @Test
    void distanceOfIdenticalPointsIsZero() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        ManhattanDistance manhattanDistance = new ManhattanDistance();

        assertEquals(0, manhattanDistance.measureDistance(p1, p2));
    }

    @Test
    void distanceToNeighbourIsOne() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(2, 2);
        ManhattanDistance manhattanDistance = new ManhattanDistance();
        assertEquals(1, manhattanDistance.measureDistance(p1, p2));
    }

    @Test
    void distanceWhereP2isUpRight() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(5, 7);
        ManhattanDistance manhattanDistance = new ManhattanDistance();
        assertEquals(8, manhattanDistance.measureDistance(p1, p2));
    }

    @Test
    void distanceWhereP2IsDownLeft() {
        Point p1 = new Point(6, 8);
        Point p2 = new Point(5, 7);
        ManhattanDistance manhattanDistance = new ManhattanDistance();
        assertEquals(2, manhattanDistance.measureDistance(p1, p2));
    }


}

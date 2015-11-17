package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReachTest {

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public int coverPoints(List<Integer> X, List<Integer> Y) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < X.size(); i++) {
            points.add(new Point(X.get(i), Y.get(i)));
        }
        Point startPoint = points.get(0);
        int distance = 0;
        for (int i = 1; i < points.size(); i++) {
            int minX = Math.abs(points.get(i).getX() - startPoint.getX());
            int minY = Math.abs(points.get(i).getY() - startPoint.getY());
            int min = Math.min(minX, minY);
            int max = Math.max(minX, minY);
            distance += (min + (max - min));
            startPoint = points.get(i);
        }

        return distance;
    }

    @Test
    public void shouldReturn0ForSinglePoint() {
        //when
        assertThat(coverPoints(Arrays.asList(1), Arrays.asList(1)), is(0));
    }

    @Test
    public void shouldReturnMinimumDistanceFromOriginForMultiplePoints() {
        //when
        assertThat(coverPoints(Arrays.asList(0, 1, 1), Arrays.asList(0, 1, 2)), is(2));
        assertThat(coverPoints(Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)), is(2));
        assertThat(coverPoints(Arrays.asList(12, -1, 4, -3, -5, 8, 9, 13, 5, 17),
                Arrays.asList(7, -8, -4, 3, 7, -8, 12, -8, 9, -7)), is(119));
    }
}

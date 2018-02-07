package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LeastBrickTest {

    private int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                sum += wall.get(i).get(j);
                map.putIfAbsent(sum, 0);
                map.put(sum, map.get(sum) + 1);
                max = Math.max(max, map.get(sum));
            }
        }
        return wall.size() - max;
    }

    @Test
    public void shouldReturnLeastBricksToBeCut() {
        List<List<Integer>> bricks = new ArrayList<>();
        bricks.add(Arrays.asList(1, 2, 2, 1));
        bricks.add(Arrays.asList(3, 1, 2));
        bricks.add(Arrays.asList(1, 3, 2));
        bricks.add(Arrays.asList(2, 4));
        bricks.add(Arrays.asList(3, 1, 2));
        bricks.add(Arrays.asList(1, 3, 1, 1));
        assertThat(leastBricks(bricks), is(2));
    }

    @Test
    public void shouldReturnLeastBricksToBeCut1() {
        List<List<Integer>> bricks = new ArrayList<>();
        bricks.add(Arrays.asList(1));
        assertThat(leastBricks(bricks), is(1));
    }

    @Test
    public void shouldReturnLeastBricksToBeCut2() {
        List<List<Integer>> bricks = new ArrayList<>();
        bricks.add(Arrays.asList(1));
        bricks.add(Arrays.asList(1));
        assertThat(leastBricks(bricks), is(2));
    }

    @Test
    public void shouldReturnLeastBricksToBeCut3() {
        List<List<Integer>> bricks = new ArrayList<>();
        bricks.add(Arrays.asList(1));
        bricks.add(Arrays.asList(1));
        bricks.add(Arrays.asList(1));
        assertThat(leastBricks(bricks), is(3));
    }

    @Test
    public void shouldReturnLeastBricksToBeCut4() {
        List<List<Integer>> bricks = new ArrayList<>();
        bricks.add(Arrays.asList(1, 1));
        bricks.add(Arrays.asList(1, 1));
        bricks.add(Arrays.asList(2));
        assertThat(leastBricks(bricks), is(1));
    }

    @Test
    public void shouldReturnLeastBricksToBeCut5() {
        List<List<Integer>> bricks = new ArrayList<>();
        bricks.add(Arrays.asList(2, 1));
        bricks.add(Arrays.asList(2, 1));
        bricks.add(Arrays.asList(2, 1));
        assertThat(leastBricks(bricks), is(0));
    }
}

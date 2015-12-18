package com.algo.dp;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UniquePathsTest {
    public int uniquePathsWithObstacles(List<List<Integer>> a) {
        for (int i = 0; i < a.get(0).size() && a.get(0).get(i) != 1; i++) {
            a.get(0).set(i, 2);
        }
        for (int i = 0; i < a.size() && a.get(i).get(0) != 1; i++) {
            a.get(i).set(0, 2);
        }
        for (int i = 1; i < a.size(); i++) {
            for (int j = 1; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) != 1) {
                    a.get(i).set(j, (a.get(i - 1).get(j) != 1 ? a.get(i - 1).get(j) : 0) + (a.get(i).get(j - 1) != 1 ? a.get(i).get(j - 1) : 0));
                }
            }
        }
        return a.get(a.size() - 1).get(a.get(a.size() - 1).size() - 1) / 2;
    }

    @Test
    public void shouldGetAllPossiblePaths() {
        assertThat(uniquePathsWithObstacles(Arrays.asList(Arrays.asList(0, 0, 0),
                Arrays.asList(0, 1, 0),
                Arrays.asList(0, 0, 0))), is(2));

        assertThat(uniquePathsWithObstacles(Arrays.asList(Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 0))), is(6));
    }
}

package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IslandPerimeterTest {

    private int islandPerimeter(int[][] grid) {
        int faces = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    faces += (i - 1) < 0 ? 1 : grid[i - 1][j] == 0 ? 1 : 0;
                    faces += (j - 1) < 0 ? 1 : grid[i][j - 1] == 0 ? 1 : 0;
                    faces += (i + 1) >= grid.length ? 1 : grid[i + 1][j] == 0 ? 1 : 0;
                    faces += (j + 1) >= grid[i].length ? 1 : grid[i][j + 1] == 0 ? 1 : 0;
                }
            }
        }
        return faces;
    }

    @Test
    public void shouldCalculatePerimeter() {
        assertThat(islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        }), is(16));

        assertThat(islandPerimeter(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
        }), is(4));
    }
}

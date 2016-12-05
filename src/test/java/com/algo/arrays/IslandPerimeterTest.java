package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IslandPerimeterTest {

    private int islandPerimeter(int[][] grid) {
        return IntStream.range(0, grid.length)
                .map(i -> IntStream.range(0, grid[i].length)
                        .map(j -> {
                            int faces = 0;
                            if (grid[i][j] != 0) {
                                faces += (i - 1) < 0 ? 1 : grid[i - 1][j] == 0 ? 1 : 0;
                                faces += (j - 1) < 0 ? 1 : grid[i][j - 1] == 0 ? 1 : 0;
                                faces += (i + 1) >= grid.length ? 1 : grid[i + 1][j] == 0 ? 1 : 0;
                                faces += (j + 1) >= grid[i].length ? 1 : grid[i][j + 1] == 0 ? 1 : 0;
                            }
                            return faces;
                        }).sum()
                ).sum();

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

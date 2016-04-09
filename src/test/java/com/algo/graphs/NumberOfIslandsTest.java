package com.algo.graphs;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumberOfIslandsTest {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    conquer(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void conquer(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 'v';
        conquer(i - 1, j, grid);
        conquer(i + 1, j, grid);
        conquer(i, j - 1, grid);
        conquer(i, j + 1, grid);
    }

    @Test
    public void shouldReturnAllIslandsCount() {
        //when
        assertThat(numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}), is(1));

        assertThat(numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}), is(3));

        assertThat(numIslands(new char[][]{
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}), is(0));

        assertThat(numIslands(new char[][]{
                {'1', '0', '1', '0', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '0', '1', '0', '1'},
                {'0', '1', '0', '1', '0'}}), is(10));

        assertThat(numIslands(new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}}), is(1));
    }
}

package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LongestIncreasingPathMatrixTest {

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            dp[i] = new int[matrix[i].length];

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (dp[i][j] == 0) {
                    populate(matrix, dp, i, j);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private int populate(int[][] matrix, int[][] dp, int i, int j) {
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            first = populate(matrix, dp, i + 1, j);
        }
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            second = populate(matrix, dp, i - 1, j);
        }
        if (j + 1 < matrix[i].length && matrix[i][j + 1] > matrix[i][j]) {
            third = populate(matrix, dp, i, j + 1);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            fourth = populate(matrix, dp, i, j - 1);
        }
        dp[i][j] = Math.max(Math.max(first, second), Math.max(third, fourth)) + 1;
        return dp[i][j];
    }

    @Test
    public void shouldGetLongestIncreasingPath() {
        assertThat(longestIncreasingPath(new int[][]{{9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}}), is(4));

        assertThat(longestIncreasingPath(new int[][]{{3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}}), is(4));

        assertThat(longestIncreasingPath(new int[][]{{1}}), is(1));
        assertThat(longestIncreasingPath(new int[][]{{1, 2}}), is(2));
        assertThat(longestIncreasingPath(new int[][]{{1, 2, 3}}), is(3));
        assertThat(longestIncreasingPath(new int[][]{{1, 1, 1},
                {1, 1, 1}}), is(1));

        assertThat(longestIncreasingPath(new int[][]{{1, 1, 1},
                {1, 1, 1}}), is(1));
        assertThat(longestIncreasingPath(new int[][]
                {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}}), is(5));
        assertThat(longestIncreasingPath(new int[][]
                {{1, 2},
                        {4, 3}}), is(4));
    }
}

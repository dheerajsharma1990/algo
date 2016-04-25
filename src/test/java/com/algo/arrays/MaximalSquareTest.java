package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaximalSquareTest {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length > 0) {
            int max = Integer.MIN_VALUE;
            int[][] count = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                count[i][0] = matrix[i][0] == '0' ? 0 : 1;
                max = Math.max(count[i][0], max);
            }
            for (int i = 0; i < matrix[0].length; i++) {
                count[0][i] = matrix[0][i] == '0' ? 0 : 1;
                max = Math.max(count[0][i], max);
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[i].length; j++) {
                    if (matrix[i][j] == '1') {
                        if (matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1' && matrix[i - 1][j - 1] == '1') {
                            count[i][j] = Math.min(Math.min(count[i - 1][j], count[i][j - 1]), count[i - 1][j - 1]) + 1;
                            max = Math.max(count[i][j], max);
                        } else {
                            count[i][j] = 1;
                        }
                    }
                }
            }
            return max * max;
        }
        return 0;
    }

    @Test
    public void shouldReturnMaxSquare() {
        assertThat(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}), is(4));

        assertThat(maximalSquare(new char[][]{{'1'}}), is(1));
        assertThat(maximalSquare(new char[][]{{'1', '1'}}), is(1));
        assertThat(maximalSquare(new char[][]{{'1'}, {'1'}}), is(1));
        assertThat(maximalSquare(new char[][]{{'1', '1'}, {'1', '1'}}), is(4));
        assertThat(maximalSquare(new char[][]{{'1', '1', '1'}, {'1', '0', '1'}, {'1', '1', '1'}}), is(1));
    }
}

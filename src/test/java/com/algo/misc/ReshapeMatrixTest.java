package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReshapeMatrixTest {


    private int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if (r * c != rows * columns) {
            return nums;
        }
        int[][] matrix = new int[r][c];
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                matrix[a][b] = nums[i][j];
                b++;
                if (b == c) {
                    b = 0;
                    a++;
                }
            }
        }
        return matrix;
    }


    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4), is(new int[][]{{1, 2, 3, 4}}));
        assertThat(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4), is(new int[][]{{1, 2}, {3, 4}}));
        assertThat(matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1), is(new int[][]{{1}, {2}, {3}, {4}}));
    }
}

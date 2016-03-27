package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MinimumCoinsTest {

    private int getMinimumCoins(List<Integer> coins, int count) {
        int[][] matrix = new int[coins.size() + 1][count + 1];
        for (int i = 1; i <= coins.size(); i++) {
            for (int j = 1; j <= count; j++) {
                int denomination = coins.get(i - 1);
                int mod = j % denomination;
                int div = j / denomination;
                if (mod == 0) {
                    matrix[i][j] = div;
                } else {
                    if (matrix[i - 1][mod] == 0) {
                        matrix[i][j] = matrix[i - 1][j];
                    } else {
                        matrix[i][j] = div + matrix[i - 1][mod];
                    }
                }
            }
        }
        return matrix[coins.size()][count];
    }

    @Test
    public void shouldGetMinimumCoins() {
        //then
        assertThat(getMinimumCoins(Arrays.asList(2, 5, 7), 9), is(2));
    }

}

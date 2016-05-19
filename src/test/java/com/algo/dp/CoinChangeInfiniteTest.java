package com.algo.dp;

import java.util.Arrays;

public class CoinChangeInfiniteTest {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] matrix = new int[coins.length + 1][amount + 1];
        matrix[0][0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            matrix[0][i] = -1;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            matrix[i][0] = 0;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j < coins[i - 1]) {
                    matrix[i][j] = matrix[i - 1][j];
                } else {
                    if (matrix[i][j - coins[i - 1]] != -1) {
                        matrix[i][j] = 1 + matrix[i][j - coins[i - 1]];
                        if (matrix[i - 1][j] != -1) {
                            matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j]);
                        }
                    } else {
                        matrix[i][j] = matrix[i - 1][j];
                    }
                }
            }
        }
        return matrix[coins.length][amount];
    }
}

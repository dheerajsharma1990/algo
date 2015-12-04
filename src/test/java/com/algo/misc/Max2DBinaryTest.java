package com.algo.misc;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class Max2DBinaryTest {

    public int getMaxBinary(int[][] matrix) {
        List<Integer> indexes = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            indexes.add(i);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            List<Integer> secondIndexes = new LinkedList<>();
            for (Integer idx : indexes) {
                if (matrix[idx][j] == 1) {
                    secondIndexes.add(idx);
                }
            }
            if (!secondIndexes.isEmpty()) {
                indexes = secondIndexes;
            }
        }
        return indexes.iterator().next() + 1;
    }

    @Test
    public void shouldGetMaxBinaryValue() {
        assertThat(getMaxBinary(new int[][]{{0, 1, 0}, {1, 1, 0}, {1, 0, 1}}), is(2));
        assertThat(getMaxBinary(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}), is(1));
        assertThat(getMaxBinary(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}}), is(1));
        assertThat(getMaxBinary(new int[][]{{1, 1, 1}, {1, 1, 1}, {0, 1, 1}}), is(1));
    }
}

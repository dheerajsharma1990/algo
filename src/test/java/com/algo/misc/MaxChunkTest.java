package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxChunkTest {

    private int maxChunksToSorted(int[] arr) {
        int count = 0;
        for (int j = 0; j < arr.length; ) {
            int num = arr[j];
            while (j < arr.length && j <= num) {
                if (arr[j] > num) {
                    num = arr[j];
                }
                j++;
            }
            count++;
        }
        return count;
    }

    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(maxChunksToSorted(new int[]{4, 3, 2, 1, 0}), is(1));
        assertThat(maxChunksToSorted(new int[]{1, 0, 2, 3, 4}), is(4));
        assertThat(maxChunksToSorted(new int[]{0}), is(1));
        assertThat(maxChunksToSorted(new int[]{0, 1, 2, 3, 4, 5}), is(6));
        assertThat(maxChunksToSorted(new int[]{0, 3, 1, 2, 4, 5}), is(4));
        assertThat(maxChunksToSorted(new int[]{0, 3, 1, 2, 5, 4}), is(3));
        assertThat(maxChunksToSorted(new int[]{3, 0, 1, 2, 5, 4}), is(2));
    }
}

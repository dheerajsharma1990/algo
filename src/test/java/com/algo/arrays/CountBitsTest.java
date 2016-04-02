package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CountBitsTest {
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        arr[0] = 0;
        int i = 1;
        while (i <= num) {
            int j = 0;
            int x = i;
            while (j < x && i <= num) {
                arr[i] = 1 + arr[j];
                j++;
                i++;
            }
        }
        return arr;
    }

    @Test
    public void shouldReturnValidBinaryNumbers() {
        assertThat(countBits(5), is(new int[]{0, 1, 1, 2, 1, 2}));
    }
}

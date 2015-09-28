package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NPlus1Test {

    public int duplicateNumber(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1]) {
                return arr[i];
            }
        }
        return 0;
    }

    @Test
    public void shouldReturnCorrectHIndex() {
        assertThat(duplicateNumber(new int[]{1, 1, 2}), is(1));
        assertThat(duplicateNumber(new int[]{1, 2, 2}), is(2));
        assertThat(duplicateNumber(new int[]{2, 3, 1, 3}), is(3));
        assertThat(duplicateNumber(new int[]{2, 2, 2, 2, 2, 2, 2}), is(2));
        assertThat(duplicateNumber(new int[]{1, 4, 3, 4, 4, 4, 4}), is(4));
    }


}

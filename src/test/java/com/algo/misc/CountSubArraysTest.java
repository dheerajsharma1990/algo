package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountSubArraysTest {

    static class CountSubArrays {
        public long count(int[] array) {
            long sum = 0;
            int i = 0;
            int j = 0;
            long count = 0;
            while (j < array.length) {
                if (array[i] <= array[j]) {
                    i = j;
                    j++;
                    count++;
                } else {
                    sum += (count * (count + 1)) / 2;
                    count = 0;
                    i = j;
                }
            }
            sum += (count * (count + 1)) / 2;
            return sum;
        }

    }


    private final CountSubArrays test = new CountSubArrays();

    @Test
    public void shouldReturnCorrectValuesForDiffScenarios() {
        //then
        assertThat(test.count(new int[]{1, 4, 2, 3}), is(6l));
        assertThat(test.count(new int[]{5}), is(1l));
        assertThat(test.count(new int[]{1, 2, 3}), is(6l));
        assertThat(test.count(new int[]{3, 2, 1}), is(3l));
        assertThat(test.count(new int[]{1, 2, 2, 1, 1, 2}), is(12l));

    }

    @Test
    public void shouldTestBoundaryCondition() {
        //given
        int arr[] = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1000000000;
        }

        //then
        assertThat(test.count(arr),is(5000050000l));
    }

}

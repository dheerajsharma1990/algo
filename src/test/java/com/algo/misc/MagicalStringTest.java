package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MagicalStringTest {

    public int magicalString(int n) {
        if ( n < 1) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        int arr[] = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 2;
        int oneCount = 1;
        int i = 2;
        int j = 2;
        while (j < (n - 1)) {
            int times = arr[i];
            int val = arr[j] == 1 ? 2 : 1;
            while (times > 0 && j < (n - 1)) {
                if (val == 1) {
                    oneCount++;
                }
                arr[++j] = val;
                times--;
            }
            i++;
        }
        return oneCount;
    }

    @Test
    public void shouldGetCountOfOnes() {
        //then
        assertThat(magicalString(1), is(1));
        assertThat(magicalString(3), is(1));
        assertThat(magicalString(6), is(3));
        assertThat(magicalString(8), is(4));
        assertThat(magicalString(19), is(9));
        assertThat(magicalString(12345), is(6172));
    }
}

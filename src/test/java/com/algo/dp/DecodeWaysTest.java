package com.algo.dp;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DecodeWaysTest {
    public int numDecodings(String a) {
        if (a.charAt(0) == '0') {
            return 0;
        }
        int arr[] = new int[a.length() + 2];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = a.charAt(0) == '0' ? 0 : 1;
        int i = 3;
        while (i < (a.length() + 2)) {
            int idx = i - 2;
            int x = a.charAt(idx) == '0' ? 0 : arr[i - 1];
            int y = 0;
            if (a.charAt(idx) == '0' && (a.charAt(idx - 1) == '1' || a.charAt(idx - 1) == '2')) {
                y = arr[i - 2];
            } else if (a.charAt(idx - 1) != '0' && Integer.valueOf(a.substring(idx - 1, idx + 1)) < 27) {
                y = arr[i - 2];
            }
            arr[i] = x + y;
            i++;
        }
        return arr[i - 1];
    }

    @Test
    public void shouldGetDecodings() {
        assertThat(numDecodings("12"), is(2));
        assertThat(numDecodings("2"), is(1));
        assertThat(numDecodings("12204"), is(2));
        assertThat(numDecodings("2020"), is(1));
        assertThat(numDecodings("2021"), is(2));
        assertThat(numDecodings("12121211212"), is(144));
        assertThat(numDecodings("2611055971756562"), is(4));
        assertThat(numDecodings("02611055971756562"), is(0));
        assertThat(numDecodings("026110055971756562"), is(0));
        assertThat(numDecodings("26110505971756562"), is(0));
    }
}

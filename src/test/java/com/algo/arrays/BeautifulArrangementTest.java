package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeautifulArrangementTest {

    private int[] constructArray(int n, int k) {
        boolean subtract = true;
        int ans[] = new int[n];
        ans[0] = n;
        for (int i = n - 1; i >= 1; i--) {
            if (k > 0) {
                if (subtract) {
                    ans[n - i] = ans[n - i - 1] - k;
                } else {
                    ans[n - i] = ans[n - i - 1] + k;
                }
                k--;
                subtract = !subtract;

            } else {
                ans[n - i] = i;
            }
        }
        return ans;
    }


    @Test
    public void shouldConstructArray() {
        //then
        assertThat(constructArray(4, 1), is(new int[]{4, 3, 2, 1}));
        assertThat(constructArray(4, 2), is(new int[]{4, 2, 3, 1}));
        assertThat(constructArray(4, 3), is(new int[]{4, 1, 3, 2}));
        assertThat(constructArray(4, 3), is(new int[]{4, 1, 3, 2}));
        assertThat(constructArray(2, 1), is(new int[]{2, 1}));
        assertThat(constructArray(10, 4), is(new int[]{10, 6, 9, 7, 8, 5, 4, 3, 2, 1}));
    }
}

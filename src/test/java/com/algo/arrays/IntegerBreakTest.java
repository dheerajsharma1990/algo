package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IntegerBreakTest {

    public int integerBreak(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int first = Math.max(j, ans[j - 1]);
                int second = Math.max(i - j, ans[i - j - 1]);
                ans[i - 1] = Math.max(ans[i - 1], first * second);
            }
        }
        return ans[n - 1];
    }

    @Test
    public void shouldGetMaxMultiplicationOnIntegerBreak() {
        assertThat(integerBreak(2), is(1));
        assertThat(integerBreak(3), is(2));
        assertThat(integerBreak(4), is(4));
        assertThat(integerBreak(5), is(6));
        assertThat(integerBreak(6), is(9));
        assertThat(integerBreak(7), is(12));
        assertThat(integerBreak(8), is(18));
        assertThat(integerBreak(9), is(27));
        assertThat(integerBreak(10), is(36));
        assertThat(integerBreak(34), is(236196));
    }

}

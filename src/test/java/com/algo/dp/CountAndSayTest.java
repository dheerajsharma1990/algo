package com.algo.dp;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CountAndSayTest {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        char[] chars = new char[]{'1'};
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            int j = 0;
            int k = 0;
            int count = 0;
            while (k < chars.length) {
                if (chars[j] == chars[k]) {
                    count++;
                    k++;
                } else {
                    builder.append(count).append(chars[j]);
                    j = k;
                    count = 0;
                }
            }
            builder.append(count).append(chars[j]);
            chars = builder.toString().toCharArray();
        }
        return new String(chars);
    }

    @Test
    public void shouldCountAndSay() {
        assertThat(countAndSay(10), is("13211311123113112211"));
    }
}

package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DiffWaysToComputeTest {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (!(ch == '+' || ch == '-' || ch == '*')) {
                continue;
            }

            List<Integer> first = diffWaysToCompute(input.substring(0, i));
            List<Integer> second = diffWaysToCompute(input.substring(i + 1));
            for (Integer f : first) {
                for (Integer s : second) {
                    ans.add(compute(f, s, ch));
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.valueOf(input));
        }
        return ans;
    }

    private Integer compute(Integer f, Integer s, char ch) {
        if (ch == '+') {
            return f + s;
        }
        if (ch == '-') {
            return f - s;
        }
        return f * s;
    }

    @Test
    public void shouldComputeInDifferentWays() {
        assertThat(diffWaysToCompute("2-1-1").size(), is(2));
        assertThat(diffWaysToCompute("2*3-4*5").size(), is(5));
    }

}

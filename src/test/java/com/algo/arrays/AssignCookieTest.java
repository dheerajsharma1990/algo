package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AssignCookieTest {

    private int findContentChildren(int[] g, int[] s) {
        int[] children = Arrays.stream(g).sorted().toArray();
        int[] cookies = Arrays.stream(s).sorted().toArray();
        int i = 0, j = 0;
        int count = 0;
        while (i < children.length && j < cookies.length) {
            if (children[i] > cookies[j]) {
                j++;
                continue;
            }
            i++;
            j++;
            count++;
        }
        return count;
    }

    @Test
    public void shouldFindMaximumContendedChildrens() {
        assertThat(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 2}), is(2));
        assertThat(findContentChildren(new int[]{2, 3, 4}, new int[]{1, 1}), is(0));
        assertThat(findContentChildren(new int[]{1, 1, 1}, new int[]{2}), is(1));
    }
}

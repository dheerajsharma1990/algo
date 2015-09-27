package com.algo.misc;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DuplicateTest {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    @Test
    public void shouldReturnCorrectResult() {
        assertThat(containsDuplicate(new int[]{1, 2, 3}), is(false));
        assertThat(containsDuplicate(new int[]{2, 1, 2}), is(true));
        assertThat(containsDuplicate(new int[]{1, 1, 1}), is(true));
    }
}

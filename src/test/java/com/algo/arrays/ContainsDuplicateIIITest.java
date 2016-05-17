package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ContainsDuplicateIIITest {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int c = nums[i];
            if (set.floor(c) != null && set.floor(c) >= c - t
                    || set.ceiling(c) != null && set.ceiling(c) <= c + t) {
                return true;
            } else {
                set.add(c);
                if (i >= k)  set.remove(nums[i - k]);
            }
        }
        return false;
    }

    @Test
    public void shouldGetNearByElements() {
        assertThat(containsNearbyAlmostDuplicate(new int[]{-3, 3}, 2, 4), is(false));
        assertThat(containsNearbyAlmostDuplicate(new int[]{4, 5, 5, 6}, 2, 1), is(true));
        assertThat(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 4}, 3, 1), is(true));
        assertThat(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 4}, 1, 1), is(true));
        assertThat(containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 4}, 0, 1), is(false));
    }
}

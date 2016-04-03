package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CountDuplicateIITest {

    class Index {
        int number;
        int index;

        public Index(int number, int index) {
            this.number = number;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            return number == index.number;

        }

        @Override
        public int hashCode() {
            return number;
        }
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Index> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Index(nums[i], i));
            } else {
                Index index = map.get(nums[i]);
                if ((i - index.index) <= k) {
                    return true;
                } else {
                    map.put(nums[i], new Index(nums[i], i));
                }
            }
        }
        return false;
    }

    @Test
    public void shouldTestVariousScenarios() {
        assertThat(containsNearbyDuplicate(new int[]{1, 2, 1, 0}, 1), is(false));
        assertThat(containsNearbyDuplicate(new int[]{1, 2, 1, 0}, 2), is(true));
        assertThat(containsNearbyDuplicate(new int[]{1, 1, 1, 1}, 0), is(false));
        assertThat(containsNearbyDuplicate(new int[]{1, 2, 3, 4}, 4), is(false));
        assertThat(containsNearbyDuplicate(new int[]{1, 2, 1}, 0), is(false));
    }
}

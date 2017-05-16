package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InsertDeleteRandomTest {

    private List<Integer> nums = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();


    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        nums.add(val);
        map.put(val, nums.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastValue = nums.get(nums.size() - 1);
        map.put(lastValue, index);
        map.remove(val);
        nums.set(index, lastValue);
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(new Random().nextInt(nums.size()));
    }


    @Test
    public void shouldReturnCorrectValuesForDiffScenarios() {
        //then
        assertThat(insert(4), is(true));
        assertThat(insert(4), is(false));
        assertThat(insert(3), is(true));
        assertThat(remove(2), is(false));
        assertThat(remove(4), is(true));
        assertThat(remove(3), is(true));
    }

}

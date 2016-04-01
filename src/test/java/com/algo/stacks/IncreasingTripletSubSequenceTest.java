package com.algo.stacks;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IncreasingTripletSubSequenceTest {

    private boolean increasingTriplet(int[] nums) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for (int num : nums) {
            if (firstList.isEmpty()) {
                firstList.add(num);
                continue;
            } else {
                if (num <= firstList.get(0)) {
                    if (firstList.size() > 1) {
                        if (secondList.isEmpty()) {
                            secondList.add(num);
                        } else {
                            if (num < secondList.get(0)) {
                                secondList.set(0, num);
                            } else if (num > secondList.get(0)) {
                                secondList.add(num);
                            }
                        }
                    } else {
                        firstList.set(0, num);
                    }
                } else {
                    if (firstList.size() > 1) {
                        if (num < firstList.get(1) && num > firstList.get(0)) {
                            firstList.set(1, num);
                        } else {
                            if (num > firstList.get(1)) {
                                return true;
                            }
                        }
                    } else {
                        if (num > firstList.get(0)) {
                            firstList.add(num);
                        }
                    }
                }
            }

            if (secondList.size() == 2 && firstList.size() == 2) {
                List<Integer> temp = firstList;
                firstList = secondList;
                secondList = temp;
                secondList.clear();
            }
        }
        return false;
    }

    @Test
    public void shouldReturnTrueForVariousScenarios() {
        assertThat(increasingTriplet(new int[]{2, 5, -1, 1, 0, 3}), is(true));
        assertThat(increasingTriplet(new int[]{1, 2}), is(false));
        assertThat(increasingTriplet(new int[]{1, 2, 3}), is(true));
        assertThat(increasingTriplet(new int[]{3, 2, 1}), is(false));
        assertThat(increasingTriplet(new int[]{1, 2, 1, 2, 1, 2}), is(false));
        assertThat(increasingTriplet(new int[]{1, 2, 1, 2, 1, 3}), is(true));
        assertThat(increasingTriplet(new int[]{2, 15, 0, 2, 5, 3}), is(true));
        assertThat(increasingTriplet(new int[]{1, 1, 2, 2, 3, 3}), is(true));
        assertThat(increasingTriplet(new int[]{1, 1, 2, 1, 1, 3}), is(true));
        assertThat(increasingTriplet(new int[]{1, 1, 2, 1, 1, 1}), is(false));
        assertThat(increasingTriplet(new int[]{1, 1, 1, 1, 1, 1}), is(false));
        assertThat(increasingTriplet(new int[]{1, 1, 1, 1, 1, 1}), is(false));
    }


}

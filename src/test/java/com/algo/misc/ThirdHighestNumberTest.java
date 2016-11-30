package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ThirdHighestNumberTest {

    public int thirdMax(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean duplicates = false;
            for (int j = 0; j < ans.size(); j++) {
                if (ans.get(j) == nums[i]) {
                    duplicates = true;
                    break;
                }
            }
            if (!duplicates) {
                ans.add(nums[i]);
                Collections.sort(ans);
                if (ans.size() > 3) {
                    ans.remove(0);
                }
            }


        }
        return ans.size() == 2 ? ans.get(1) : ans.get(0);
    }

    @Test
    public void shouldGiveTheMaxForOneSizeArray() {
        assertThat(thirdMax(new int[]{1}), is(1));
    }

    @Test
    public void shouldGiveTheMaxForTwoSizeArray() {
        assertThat(thirdMax(new int[]{1, 2}), is(2));
    }

    @Test
    public void shouldGiveTheMaxForThreeSizeDuplicateArray() {
        assertThat(thirdMax(new int[]{1, 2, 2}), is(2));
    }

    @Test
    public void shouldGiveTheMaxForThreeSizeDistinctArray() {
        assertThat(thirdMax(new int[]{1, 2, 3}), is(1));
    }

    @Test
    public void shouldGiveTheMaxForThreeSizeDistinctArrayWithSomeDuplicates() {
        assertThat(thirdMax(new int[]{2, 2, 3, 1}), is(1));
    }

    @Test
    public void shouldGiveTheMaxForTwoSizeDistinctArrayWithSomeDuplicates() {
        assertThat(thirdMax(new int[]{5, 2, 2}), is(5));
    }

}

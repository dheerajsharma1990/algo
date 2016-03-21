package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RepeatMissingTest {

    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer integer : a) {
            if (!set.contains(integer)) {
                set.add(integer);
            } else {
                ans.add(integer);
            }
        }
        for (int i = 1; i <= a.size(); i++) {
            if (!set.contains(i)) {
                ans.add(i);
                break;
            }
        }
        return ans;
    }

    @Test
    public void shouldTestForVariousScenarios() {
        //when
        List<Integer> ans1 = repeatedNumber(Arrays.asList(3, 1, 5, 2, 3));
        List<Integer> ans2 = repeatedNumber(Arrays.asList(1,2,1));

        //then
        assertThat(ans1.size(), is(2));
        assertThat(ans1.get(0), is(3));
        assertThat(ans1.get(1), is(4));

        assertThat(ans2.size(), is(2));
        assertThat(ans2.get(0), is(1));
        assertThat(ans2.get(1), is(3));
    }

}

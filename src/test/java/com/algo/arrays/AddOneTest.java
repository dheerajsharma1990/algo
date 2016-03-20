package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddOneTest {

    public ArrayList<Integer> plusOne(List<Integer> a) {
        int carry = 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            ans.add((a.get(i) + carry) % 10);
            carry = (a.get(i) + carry) / 10;
        }
        if (carry != 0) {
            ans.add(1);
        }
        int j = ans.size() - 1;
        for (int i = ans.size() - 1; i >= 0 && ans.get(i) == 0; i--) {
            j--;
        }
        ArrayList<Integer> finalAns = new ArrayList<>();
        for (int i = j; i >= 0; i--) {
            finalAns.add(ans.get(i));
        }
        return finalAns;
    }

    @Test
    public void shouldAddOneToASingleDigit() {
        //when
        List<Integer> ans = plusOne(Arrays.asList(1));

        //then
        assertThat(ans.size(), is(1));
        assertThat(ans.iterator().next(), is(2));
    }

    @Test
    public void shouldAddOneToTwoDigit() {
        //when
        List<Integer> ans = plusOne(Arrays.asList(1, 2));

        //then
        assertThat(ans.size(), is(2));
        assertThat(ans.get(0), is(1));
        assertThat(ans.get(1), is(3));
    }

    @Test
    public void shouldAddOneTo9() {
        //when
        List<Integer> ans = plusOne(Arrays.asList(9));

        //then
        assertThat(ans.size(), is(2));
        assertThat(ans.get(0), is(1));
        assertThat(ans.get(1), is(0));
    }
}

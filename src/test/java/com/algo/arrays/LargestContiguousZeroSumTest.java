package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LargestContiguousZeroSumTest {

    public ArrayList<Integer> lszero(ArrayList<Integer> a) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0;
        int minIndex = a.size();
        int currIndex = a.size();
        sumIndexMap.put(0, -1);
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            if (sumIndexMap.containsKey(sum)) {
                if ((i - sumIndexMap.get(sum)) > currIndex - minIndex) {
                    minIndex = sumIndexMap.get(sum);
                    currIndex = i;
                }
            } else {
                sumIndexMap.put(sum, i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = minIndex + 1; i <= currIndex; i++) {
            ans.add(a.get(i));
        }
        return ans;
    }

    @Test
    public void shouldGetLargestSequenceWithZeroSum() {
        assertThat(lszero(new ArrayList<>(Arrays.asList(1, 2, -2, 4, -4))), is(new ArrayList<>(Arrays.asList(2, -2, 4, -4))));
        assertThat(lszero(new ArrayList<>(Arrays.asList(1))).size(), is(0));
        assertThat(lszero(new ArrayList<>(Arrays.asList(2, -2, 2, -2, 2, -2))), is(new ArrayList<>(Arrays.asList(2, -2, 2, -2, 2, -2))));
        assertThat(lszero(new ArrayList<>(Arrays.asList(0, 0))), is(new ArrayList<>(Arrays.asList(0, 0))));
        assertThat(lszero(new ArrayList<>(Arrays.asList(0))), is(new ArrayList<>(Arrays.asList(0))));
        assertThat(lszero(new ArrayList<>(Arrays.asList(1, 2, 3, -3, -2, 1))), is(new ArrayList<>(Arrays.asList(2, 3, -3, -2))));
        assertThat(lszero(new ArrayList<>(Arrays.asList(1, 2, 3, -3, -2, -1))), is(new ArrayList<>(Arrays.asList(1, 2, 3, -3, -2, -1))));

    }
}

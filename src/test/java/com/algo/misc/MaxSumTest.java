package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxSumTest {

    public ArrayList<Integer> maxset(List<Integer> a) {
        long previousSum = 0;
        int previousLength = 0;
        int previousIndex = -1;
        long currentSum = 0;
        int currentLength = 0;
        int currentIndex = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < 0) {
                if (currentSum > previousSum || currentSum == previousSum && (currentLength > previousLength)) {
                    previousSum = currentSum;
                    previousLength = currentLength;
                    previousIndex = currentIndex;
                }
                currentIndex = -1;
                currentSum = 0;
                currentLength = 0;
            } else {
                currentSum += a.get(i);
                currentLength++;
                currentIndex = i - currentLength + 1;
            }
        }
        if (currentSum > previousSum || currentSum == previousSum && (currentLength > previousLength)) {
            previousLength = currentLength;
            previousIndex = currentIndex;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = previousIndex, j = 0; j < previousLength; j++) {
            ans.add(a.get(i++));
        }
        return ans;
    }

    @Test
    public void shouldGetMaxSumForSingleElementArray() {
        //then
        assertThat(maxset(Arrays.asList(-1)).size(), is(0));
    }

    @Test
    public void shouldGetMaxSumForAll0ElementsArray() {
        //then
        assertThat(maxset(Arrays.asList(0, 0, 0, 0)), hasItems(0, 0, 0, 0));
    }

    @Test
    public void shouldGetMaxSumForDifferentArray() {
        //then
        assertThat(maxset(Arrays.asList(1, 2, 5, -7, 2, 3)), hasItems(1, 2, 5));
        assertThat(maxset(Arrays.asList(1, 2, -1, 1, 1, 1)), hasItems(1, 1, 1));
        assertThat(maxset(Arrays.asList(1, 2, -1, 3, 0)), hasItems(1, 2));
        assertThat(maxset(Arrays.asList(1, 2, 5, -7, 2, 3)), hasItems(1, 2, 5));
        assertThat(maxset(Arrays.asList(-1, -1, -1)).size(), is(0));
        assertThat(maxset(Arrays.asList(-846930886, -1714636915, 424238335, -1649760492)), hasItems(424238335));
        assertThat(maxset(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368)), hasItems(1967513926, 1540383426));
        assertThat(maxset(Arrays.asList(336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421)), hasItems(1101513929, 1315634022));
    }

}

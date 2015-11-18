package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class WaveTest {

    public List<Integer> wave(List<Integer> a) {
        Collections.sort(a);
        int i = 0;
        int j = 1;
        while (j < a.size()) {
            Integer temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
            i+=2;
            j+=2;
        }
        return a;
    }

    @Test
    public void shouldOperateForSingleElement() {
        //then
        assertThat(wave(Arrays.asList(1)), hasItems(1));
    }

    @Test
    public void shouldOperateForMultipleElement() {
        //then
        assertThat(wave(Arrays.asList(2, 1, 4, 3)), hasItems(2, 1, 4, 3));
    }
}

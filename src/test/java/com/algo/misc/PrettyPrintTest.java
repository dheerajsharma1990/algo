package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class PrettyPrintTest {
    public List<List<Integer>> prettyPrint(int a) {
        int maxLine = 2 * (a - 1) + 1;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < maxLine; i++) {
            lists.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxLine; i++) {
            for (int j = 0; j < maxLine; j++) {
                lists.get(i).add(0);
            }
        }
        for (int i = 0; i < maxLine; i++) {
            for (int k = i; k < (maxLine - i); k++) {
                lists.get(i).set(k, a - i);
                lists.get(maxLine - i - 1).set(k, a - i);
                lists.get(k).set(i, a - i);
                lists.get(k).set(maxLine - i - 1, a - i);
            }
        }
        return lists;
    }

    @Test
    public void shouldCreatePrettyPrintFor4() {
        //then
        assertThat(prettyPrint(4).get(0), hasItems(4, 4, 4, 4, 4, 4, 4));
        assertThat(prettyPrint(4).get(1), hasItems(4, 3, 3, 3, 3, 3, 4));
        assertThat(prettyPrint(4).get(2), hasItems(4, 3, 2, 2, 2, 3, 4));
        assertThat(prettyPrint(4).get(3), hasItems(4, 3, 2, 1, 2, 3, 4));
        assertThat(prettyPrint(4).get(4), hasItems(4, 3, 2, 2, 2, 3, 4));
        assertThat(prettyPrint(4).get(5), hasItems(4, 3, 3, 3, 3, 3, 4));
        assertThat(prettyPrint(4).get(6), hasItems(4, 4, 4, 4, 4, 4, 4));
    }

    @Test
    public void shouldCreatePrettyPrintFor2() {
        //then
        assertThat(prettyPrint(2).get(0), hasItems(2, 2, 2));
        assertThat(prettyPrint(2).get(1), hasItems(2, 1, 2));
        assertThat(prettyPrint(2).get(2), hasItems(2, 2, 2));
    }

    @Test
    public void shouldCreatePrettyPrintFor1() {
        //then
        assertThat(prettyPrint(1).get(0), hasItems(1));
    }

}

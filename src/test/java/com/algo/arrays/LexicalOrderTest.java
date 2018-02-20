package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LexicalOrderTest {

    private List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        addNumber(1, n, ans);
        return ans;
    }

    private void addNumber(int i, int n, List<Integer> ans) {
        if (i <= n && ans.size() < n) {
            ans.add(i);
            addNumber(i * 10, n, ans);
            if ((i + 1) % 10 != 0) {
                addNumber(i + 1, n, ans);
            }
        }
    }


    @Test
    public void shouldReturnInLexicalOrder() {
        assertThat(lexicalOrder(1000).size(), is(1000));
        assertThat(lexicalOrder(100).size(), is(100));
        assertThat(lexicalOrder(13).size(), is(13));
    }
}

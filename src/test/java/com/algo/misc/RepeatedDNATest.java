package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RepeatedDNATest {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String substring = s.substring(i, i + 10);
            if (set.contains(substring)) {
                ans.add(substring);
            }
            set.add(substring);
        }
        List<String> str = new ArrayList<>();
        str.addAll(ans);
        return str;
    }

    @Test
    public void shouldReturnRepeatedDNASequence() {
        List<String> list = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

        //then
        assertThat(list, hasItems("AAAAACCCCC", "CCCCCAAAAA"));
    }

    @Test
    public void shouldReturnRepeatedDNASequenceWithSameRepeatedSequence() {
        List<String> list = findRepeatedDnaSequences("AAAAAAAAAAA");

        //then
        assertThat(list, hasItems("AAAAAAAAAA"));
        assertThat(list.size(), is(1));
    }

}
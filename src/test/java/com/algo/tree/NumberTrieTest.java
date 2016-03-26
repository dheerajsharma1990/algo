package com.algo.tree;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumberTrieTest {

    class Trie {
        private int digit;
        private boolean ending;
        private Trie[] tries = new Trie[10];

        public Trie(int digit, boolean ending, Trie[] tries) {
            this.digit = digit;
            this.ending = ending;
            this.tries = tries;
        }
    }

    private Trie populate(Set<Integer> numbers) {
        Trie root = new Trie(-1, true, new Trie[10]);
        for (Integer integer : numbers) {
            Trie head = root;
            List<Integer> digits = new ArrayList<>();
            populateDigits(digits, integer);
            for (Integer i : digits) {
                if (head.tries[i] == null) {
                    Trie t = new Trie(i, false, new Trie[10]);
                    head.tries[i] = t;
                    head = t;
                } else {
                    head = head.tries[i];
                }
            }
            head.ending = true;

        }
        return root;
    }

    private void populateDigits(List<Integer> digits, Integer integer) {
        if (integer == 0) {
            digits.add(0);
            return;
        }
        while (integer != 0) {
            Integer div = integer / 10;
            Integer rem = integer % 10;
            digits.add(0, rem);
            integer = div;
        }
    }

    private boolean isPresent(Trie trie, Integer number) {
        List<Integer> digits = new ArrayList<>();
        populateDigits(digits, number);
        for (Integer digit : digits) {
            if (trie == null) {
                return false;
            }
            trie = trie.tries[digit];
        }
        return trie != null && trie.ending;
    }

    @Test
    public void shouldTestVariousScenarios() {
        //when
        Trie trie = populate(new HashSet<Integer>(Arrays.asList(0, 12, 41)));
        //then
        assertThat(isPresent(trie, 0), is(true));
        assertThat(isPresent(trie, 13), is(false));
        assertThat(isPresent(trie, 41), is(true));
        assertThat(isPresent(trie, 14), is(false));
        assertThat(isPresent(trie, 12), is(true));
    }
}

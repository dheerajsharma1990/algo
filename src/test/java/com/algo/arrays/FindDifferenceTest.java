package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindDifferenceTest {

    private char findTheDifference(String s, String t) {
        Map<Character, Long> collect = t.chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        s.chars().forEach(i -> collect.put((char) i, collect.get((char) i) - 1));
        return collect.entrySet().stream().filter(entry -> entry.getValue() != 0l).findFirst().get().getKey();
    }

    @Test
    public void shouldFindDifference() {
        assertThat(findTheDifference("abc", "bcda"), is('d'));
        assertThat(findTheDifference("", "a"), is('a'));
        assertThat(findTheDifference("aa", "aba"), is('b'));
    }
}

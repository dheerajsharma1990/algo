package com.algo.strings;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxLengthPalindromeTest {

    private int longestPalindrome(String s) {
        Map<String, Long> countMap = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Long sum = countMap.values()
                .stream()
                .map(value -> (value / 2) * 2)
                .reduce(0L, Long::sum);
        return (int) (countMap.values().stream().anyMatch(l -> l % 2 == 1) ? sum + 1 : sum);
    }

    @Test
    public void shouldGetLongestPalindromeLength() {
        //then
        assertThat(longestPalindrome("abccccdd"), is(7));
        assertThat(longestPalindrome("aa"), is(2));
        assertThat(longestPalindrome("aaa"), is(3));
        assertThat(longestPalindrome("a"), is(1));
        assertThat(longestPalindrome("ab"), is(1));
        assertThat(longestPalindrome("aba"), is(3));
    }


}

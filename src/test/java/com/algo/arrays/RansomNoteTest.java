package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RansomNoteTest {

    private boolean canConstruct(String ransomNote, String magazine) {
        Function<String,Map<Character,Long>> function = (s) -> s.chars().mapToObj(i -> (char) i)
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> ransomNoteMap = function.apply(ransomNote);
        Map<Character, Long> magazineMap = function.apply(magazine);
        return ransomNoteMap.entrySet().stream()
                .allMatch(entry -> magazineMap.containsKey(entry.getKey()) && magazineMap.get(entry.getKey()) >= entry.getValue());
    }

    @Test
    public void shouldTestRansomNoteConstruction() {
        assertThat(canConstruct("a", "b"), is(false));
        assertThat(canConstruct("aa", "ab"), is(false));
        assertThat(canConstruct("aa", "aab"), is(true));
        assertThat(canConstruct("a", "a"), is(true));
        assertThat(canConstruct("a", ""), is(false));
    }
}

package com.algo.strings;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FirstNonRepeatingCharacterTest {

    private int firstUniqChar(String s) {
        Map<String, Long> countMap = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return IntStream.range(0, s.length())
                .filter(i -> countMap.get(String.valueOf(s.charAt(i))) == 1)
                .findFirst()
                .orElse(-1);
    }

    @Test
    public void shouldReturnFirstUniqueCharacter() {
        //then
        assertThat(firstUniqChar("loveleetcode"), is(2));
        assertThat(firstUniqChar("aa"), is(-1));
        assertThat(firstUniqChar("leetcode"), is(0));
    }


}

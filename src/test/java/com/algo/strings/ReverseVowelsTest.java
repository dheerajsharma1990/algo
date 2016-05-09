package com.algo.strings;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReverseVowelsTest {
    public String reverseVowels(String s) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
                    s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U') {
                list.add(i);
            }
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < list.size() / 2; i++) {
            char temp = arr[list.get(i)];
            arr[list.get(i)] = arr[list.get(list.size() - i - 1)];
            arr[list.get(list.size() - i - 1)] = temp;
        }
        return new String(arr);
    }

    @Test
    public void shouldReverseVowels() {
        assertThat(reverseVowels("hello"), is("holle"));
        assertThat(reverseVowels("aeiou"), is("uoiea"));
        assertThat(reverseVowels("leetcode"), is("leotcede"));
        assertThat(reverseVowels("bcd"), is("bcd"));
        assertThat(reverseVowels("b"), is("b"));
        assertThat(reverseVowels("a"), is("a"));
        assertThat(reverseVowels("abc"), is("abc"));
        assertThat(reverseVowels("aA"), is("Aa"));
    }
}

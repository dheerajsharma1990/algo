package com.algo.strings;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RemoveDuplicateLettersTest {

    public String removeDuplicateLetters(String s) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < s.length(); i++) {
            list.get(s.charAt(i) - 'a').add(i);
        }
        Deque<Character> deque = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (deque.isEmpty()) {
                list.get(s.charAt(i) - 'a').remove(0);
                deque.addLast(s.charAt(i));
                set.add(s.charAt(i));
            } else {
                while (!deque.isEmpty() && (deque.peekLast() >= s.charAt(i) && !list.get(deque.peekLast() - 'a').isEmpty()) && !set.contains(s.charAt(i))) {
                    Character character = deque.removeLast();
                    set.remove(character);
                }
                list.get(s.charAt(i) - 'a').remove(0);
                if (!set.contains(s.charAt(i))) {
                    set.add(s.charAt(i));
                    deque.addLast(s.charAt(i));
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            builder.append(deque.removeFirst());
        }
        return builder.toString();
    }

    @Test
    public void shouldRemoveDuplicateLetters() {
        assertThat(removeDuplicateLetters("abacb"), is("abc"));
        assertThat(removeDuplicateLetters("bcabc"), is("abc"));
        assertThat(removeDuplicateLetters("cbacdcbc"), is("acdb"));
        assertThat(removeDuplicateLetters("aaaa"), is("a"));
        assertThat(removeDuplicateLetters("a"), is("a"));
        assertThat(removeDuplicateLetters("abcd"), is("abcd"));
        assertThat(removeDuplicateLetters("abcdcba"), is("abcd"));
        assertThat(removeDuplicateLetters("abcdcba"), is("abcd"));
        assertThat(removeDuplicateLetters("proabreqmorabcdfghertpasbnmwqpadrshgfdasbrtuisbnmpodrbds"), is("abcdemwqhgfrtuinpos"));
    }
}

package com.algo.strings;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class IsomorphicStringTest {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                if (!set.contains(t.charAt(i))) {
                    map.put(ch, t.charAt(i));
                    set.add(t.charAt(i));
                } else {
                    return false;
                }
            } else {
                if (t.charAt(i) != map.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void shouldTestIsomorphism() {
        assertThat(isIsomorphic("egg", "add"), is(true));
        assertThat(isIsomorphic("foo", "bar"), is(false));
        assertThat(isIsomorphic("paper", "title"), is(true));
        assertThat(isIsomorphic("add", "aaa"), is(false));
        assertThat(isIsomorphic("aaa", "aaa"), is(true));
    }
}

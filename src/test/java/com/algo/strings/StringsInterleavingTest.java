package com.algo.strings;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringsInterleavingTest {

    class Range {
        int firstStart;
        int secondStart;

        public Range(int firstStart, int secondStart) {
            this.firstStart = firstStart;
            this.secondStart = secondStart;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Range range = (Range) o;

            if (firstStart != range.firstStart) return false;
            return secondStart == range.secondStart;

        }

        @Override
        public int hashCode() {
            int result = firstStart;
            result = 31 * result + secondStart;
            return result;
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != (s1.length() + s2.length())) {
            return false;
        }
        Range range = new Range(0, 0);
        Map<Range, Boolean> map = new HashMap<>();
        return isInterleave(s1, s2, s3, range, 0, map);
    }

    private boolean isInterleave(String s1, String s2, String s3, Range range, int k, Map<Range, Boolean> map) {
        if (map.containsKey(range)) {
            return map.get(range);
        }
        if (range.firstStart == s1.length()) {
            if (s2.substring(range.secondStart).equals(s3.substring(k))) {
                map.put(range, true);
                return true;
            } else {
                map.put(range, false);
                return false;
            }
        }

        if (range.secondStart == s2.length()) {
            if (s1.substring(range.firstStart).equals(s3.substring(k))) {
                map.put(range, true);
                return true;
            } else {
                map.put(range, false);
                return false;
            }
        }

        if ((s1.charAt(range.firstStart) == s3.charAt(k)) && (s2.charAt(range.secondStart) == s3.charAt(k))) {
            boolean ans = isInterleave(s1, s2, s3, new Range(range.firstStart + 1, range.secondStart), k + 1, map) ||
                    isInterleave(s1, s2, s3, new Range(range.firstStart, range.secondStart + 1), k + 1, map);
            map.put(range, ans);
            return ans;
        }
        if (s1.charAt(range.firstStart) == s3.charAt(k)) {
            boolean ans = isInterleave(s1, s2, s3, new Range(range.firstStart + 1, range.secondStart), k + 1, map);
            map.put(range, ans);
            return ans;
        }
        if (s2.charAt(range.secondStart) == s3.charAt(k)) {
            boolean ans = isInterleave(s1, s2, s3, new Range(range.firstStart, range.secondStart + 1), k + 1, map);
            map.put(range, ans);
            return ans;
        }
        map.put(range, false);
        return false;

    }

    @Test
    public void shouldCheckForInterleavingStrings() {
        assertThat(isInterleave("aa", "ab", "aaab"), is(true));
        assertThat(isInterleave("aa", "ab", "abaa"), is(true));
        assertThat(isInterleave("aabcc", "dbbca", "aadbbcbcac"), is(true));
        assertThat(isInterleave("aabcc", "dbbca", "aadbbbaccc"), is(false));
        assertThat(isInterleave("aaaaaaaaa", "aaaaaaaab", "aaaaaaaaaaaaaaaaab"), is(true));
        assertThat(isInterleave("aaaaaaaaa", "aaaaaaaab", "aaaaaaaaaaaaaaaaaa"), is(false));
        assertThat(isInterleave("aaaaaaaaa", "aaaaaaaab", "aaaaaaaabaaaaaaaaa"), is(true));
        assertThat(isInterleave("aaaaaaaaa", "aaaaaaaab", "aaaaaaaaaabaaaaaaa"), is(true));
        assertThat(isInterleave("aaaaaaaaa", "aaaaaaaab", "aaaaaabaaaaaaaaaaa"), is(false));
        assertThat(isInterleave("aaaaaaaaaaaaaaaaaaaaaaaaaaa", "bababababababababababababab", "babababababababababababababaaaaaaaaaaaaaaaaaaaaaaaaaaa"), is(true));
        assertThat(isInterleave("a", "b", "ab"), is(true));
        assertThat(isInterleave("a", "b", "ba"), is(true));
        assertThat(isInterleave("ab", "b", "bab"), is(true));
        assertThat(isInterleave("ab", "b", "bbb"), is(false));
    }

}

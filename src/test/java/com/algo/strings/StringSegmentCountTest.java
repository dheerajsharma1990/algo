package com.algo.strings;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringSegmentCountTest {

    private int countSegments(String s) {
        boolean isChar = false;
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (isChar) {
                    isChar = false;
                    count++;
                }
            } else {
                isChar = true;
            }
        }
        count = isChar ? count + 1 : count;
        return count;
    }


    @Test
    public void shouldCountSegments() {
        //then
        assertThat(countSegments("Hello, my name is John"), is(5));
        assertThat(countSegments("Hello, my name is John "), is(5));
        assertThat(countSegments("Hello, my name is John  "), is(5));
        assertThat(countSegments("Hello,  my  name is   John  "), is(5));
        assertThat(countSegments("   Hello,  my  name is   John  "), is(5));
        assertThat(countSegments("   H"), is(1));
        assertThat(countSegments("abc"), is(1));
        assertThat(countSegments("  "), is(0));
    }


}

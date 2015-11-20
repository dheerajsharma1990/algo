package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PalindromeTest {

    public int isPalindrome(String a) {
        StringBuilder builder = new StringBuilder();
        for (Character character : a.toCharArray()) {
            if ((character >= 'A' && character <= 'Z') ||
                    (character >= 'a' && character <= 'z') ||
                    (character >= '0' && character <= '9')) {
                builder.append(character);
            }
        }
        char[] chars = builder.toString().toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return 0;
            }
        }
        return 1;
    }
    @Test
    public void shouldCheckForPalindromes() {
        assertThat(isPalindrome("A man, a plan, a canal: Panama"), is(1));
        assertThat(isPalindrome("race a car"), is(0));
        assertThat(isPalindrome("rac1 1 car"), is(1));
    }
}

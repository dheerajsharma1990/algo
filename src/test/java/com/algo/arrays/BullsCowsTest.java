package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BullsCowsTest {

    public String getHint(String secret, String guess) {
        int matchCount = 0;
        int unMatchCount = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                matchCount++;
            } else {
                if (charCount.containsKey(secret.charAt(i))) {
                    charCount.put(secret.charAt(i), charCount.get(secret.charAt(i)) + 1);
                } else {
                    charCount.put(secret.charAt(i), 1);
                }
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (charCount.containsKey(guess.charAt(i))) {
                    unMatchCount++;
                    int count = charCount.get(guess.charAt(i));
                    if (count == 1) {
                        charCount.remove(guess.charAt(i));
                    } else {
                        charCount.put(guess.charAt(i), --count);
                    }
                }
            }
        }
        return String.valueOf(matchCount) + "A" + String.valueOf(unMatchCount) + "B";
    }

    @Test
    public void shouldTestVariousScenarios() {
        assertThat(getHint("1807", "7810"), is("1A3B"));
        assertThat(getHint("1123", "0111"), is("1A1B"));
        assertThat(getHint("1111", "1111"), is("4A0B"));
        assertThat(getHint("11120", "01011"), is("1A3B"));
        assertThat(getHint("1122", "0001"), is("0A1B"));
        assertThat(getHint("1122", "0011"), is("0A2B"));
    }
}

package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MinimumNumberFromSequenceTest {

    private String minimumNumberFromSequence(String sequence) {
        sequence = sequence + (sequence.charAt(sequence.length() - 1) == 'D' ? 'D' : 'I');
        int i = -1;
        int j = 0;
        char tillNow = '1';
        char[] ans = new char[sequence.length()];
        while (j < sequence.length()) {
            if (sequence.charAt(j) == 'I') {
                int k = j;
                while (k != i) {
                    ans[k] = tillNow;
                    tillNow++;
                    k--;
                }
                i = j;
            }
            j++;
        }
        if (i != sequence.length() - 1) {
            --j;
            while (j != i) {
                ans[j] = tillNow;
                tillNow++;
                j--;
            }
        }
        return new String(ans);
    }

    @Test
    public void shouldGetMinimumNumber() {
        assertThat(minimumNumberFromSequence("D"), is("21"));
        assertThat(minimumNumberFromSequence("I"), is("12"));
        assertThat(minimumNumberFromSequence("DD"), is("321"));
        assertThat(minimumNumberFromSequence("III"), is("1234"));
        assertThat(minimumNumberFromSequence("DIDI"), is("21435"));
        assertThat(minimumNumberFromSequence("IIDDD"), is("126543"));
        assertThat(minimumNumberFromSequence("DDIDDIID"), is("321654798"));
    }

}

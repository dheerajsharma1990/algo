package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaximumWinningTest {

    static class MaximumWinning {
        public int count(String question, String answer, int[] winning) {
            int correct = 0;
            for (int i = 0; i < question.length(); i++) {
                if (question.charAt(i) == answer.charAt(i)) {
                    correct++;
                }
            }
            return correct == question.length() ? winning[question.length()] : getMax(winning, 0, correct);
        }

        private int getMax(int[] winning, int start, int end) {
            int max = -1;
            for (int i = start; i <= end; i++) {
                max = max > winning[i] ? max : winning[i];
            }
            return max;
        }

    }


    private final MaximumWinning test = new MaximumWinning();

    @Test
    public void shouldReturnCorrectValuesForDiffScenarios() {
        //then
        assertThat(test.count("ABCDE", "EBCDA", new int[]{0, 10, 20, 30, 40, 50}), is(30));
        assertThat(test.count("CHEF", "QUIZ", new int[]{4, 3, 2, 1, 0}), is(4));
        assertThat(test.count("ABBABAAB", "ABABABAB", new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100}), is(100));
        assertThat(test.count("ABC", "ABC", new int[]{3, 2, 1, 0}), is(0));
        assertThat(test.count("ABC", "ABC", new int[]{0, 1, 2, 3}), is(3));

    }


}

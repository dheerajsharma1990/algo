package com.algo.misc;

import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxChainTest {

    private int solution(int[] A, int[] B) {
        return IntStream.range(0, 7)
                .map(i -> {
                    int same = (int) IntStream.range(0, A.length)
                            .filter(j -> (A[j] == i && B[j] == i))
                            .count();
                    int diff = (int) IntStream.range(0, A.length)
                            .filter(j -> A[j] != B[j] && (A[j] == i || B[j] == i))
                            .count();
                    return (2 * same + Math.max(diff % 2 == 0 ? diff : diff - 1, 0));
                }).max().getAsInt();
    }

    @Test
    public void shouldWorkCorrectlyForDiffScenarios() {
        assertThat(solution(new int[]{1, 5, 4, 5, 2}, new int[]{2, 5, 5, 5, 2}), is(5));
        assertThat(solution(new int[]{1}, new int[]{0}), is(1));
        assertThat(solution(new int[]{1, 1}, new int[]{1, 1}), is(4));
        assertThat(solution(new int[]{1, 2}, new int[]{1, 2}), is(2));
        assertThat(solution(new int[]{1, 1}, new int[]{2, 2}), is(2));
        assertThat(solution(new int[]{1, 1}, new int[]{2, 3}), is(2));
        assertThat(solution(new int[]{0, 0, 0}, new int[]{0, 0, 3}), is(5));
        assertThat(solution(new int[]{0, 0, 0, 0}, new int[]{0, 0, 3, 6}), is(6));
        assertThat(solution(new int[]{0, 0, 0, 0}, new int[]{0, 0, 3, 6}), is(6));
        assertThat(solution(new int[]{0, 0, 1, 1, 2, 2, 2}, new int[]{0, 0, 1, 1, 2, 2, 2}), is(6));
        assertThat(solution(new int[]{2, 0, 1, 1, 2, 2, 2}, new int[]{0, 2, 1, 1, 2, 2, 2}), is(8));
        assertThat(solution(new int[]{6, 0}, new int[]{6, 1}), is(2));

    }

}

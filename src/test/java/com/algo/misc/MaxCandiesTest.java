package com.algo.misc;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MaxCandiesTest {

    private int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        Set<Integer> distinctInA = new HashSet<>();
        Set<Integer> distinctInB = new HashSet<>();
        Set<Integer> commonInBoth = new HashSet<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                int value = A[i];
                commonInBoth.add(value);
                while (i < A.length && A[i] == value) {
                    i++;
                }
                while (j < B.length && B[j] == value) {
                    j++;
                }
            } else if (A[i] < B[j]) {
                if (!distinctInA.contains(A[i])) {
                    distinctInA.add(A[i]);
                }
                i++;
            } else {
                if (!distinctInB.contains(B[j])) {
                    distinctInB.add(B[j]);
                }
                j++;
            }
        }
        while (i < A.length) {
            if (!distinctInA.contains(A[i])) {
                distinctInA.add(A[i]);
            }
            i++;
        }
        while (j < B.length) {
            if (!distinctInB.contains(B[j])) {
                distinctInB.add(B[j]);
            }
            j++;
        }
        int sizeA = distinctInA.size();
        int sizeB = distinctInB.size();
        int common = commonInBoth.size();
        int half = A.length / 2;
        int mid = Math.min(sizeA, half) + Math.min(sizeB, half);
        return mid + Math.min(common, 2 * half - mid);
    }

    @Test
    public void shouldWorkCorrectlyForDiffScenarios() {
        assertThat(solution(new int[]{1, 2, 3, 4}, new int[]{3, 3, 3, 7}), is(4));
        assertThat(solution(new int[]{1, 1}, new int[]{2, 1}), is(2));
        assertThat(solution(new int[]{1, 1}, new int[]{1, 1}), is(1));
        assertThat(solution(new int[]{1, 2}, new int[]{3, 4}), is(2));
        assertThat(solution(new int[]{1, 2, 3, 4}, new int[]{3, 4, 1, 2}), is(4));
        assertThat(solution(new int[]{2, 2, 2, 2, 2, 2}, new int[]{7, 4, 5, 2, 1, 2}), is(4));
        assertThat(solution(new int[]{2, 2, 2, 2, 4, 2, 6, 6}, new int[]{3, 3, 3, 1, 3, 3, 6, 6}), is(5));
    }

}

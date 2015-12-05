package com.algo.dp;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoinChangeTest {

    public int coinchange2(List<Integer> a, int b) {
        int count[][] = new int[b + 1][a.size()];
        for (int i = 0; i < a.size(); i++) {
            count[0][i] = 1;
        }
        for (int i = 1; i < b + 1; i++) {
            for (int j = 0; j < a.size(); j++) {
                count[i][j] = ((((j > 0) ? count[i][j - 1] : 0) % 1000007) + (((i - a.get(j) >= 0) ? count[i - a.get(j)][j] : 0)) % 1000007) % 1000007;
            }

        }
        return count[b][a.size() - 1];
    }

    @Test
    public void shouldGetCorrectChangeCount() {
        assertThat(coinchange2(Arrays.asList(1, 2, 3, 4), 4), is(5));
        assertThat(coinchange2(Arrays.asList(1, 2, 3), 4), is(4));
        assertThat(coinchange2(Arrays.asList(2, 4, 6), 5), is(0));
        assertThat(coinchange2(Arrays.asList(1), 5), is(1));
        assertThat(coinchange2(Arrays.asList(3, 5, 7, 11), 20), is(5));
        assertThat(coinchange2(Arrays.asList(2, 3, 6), 10), is(3));
        assertThat(coinchange2(Arrays.asList(6, 3, 2), 10), is(3));
        assertThat(coinchange2(Arrays.asList(18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8), 458), is(867621));
    }

}

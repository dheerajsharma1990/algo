package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StoneWinnerTest {
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }

    @Test
    public void shouldReturnCorrectResult() {
        assertThat(canWinNim(1), is(true));
        assertThat(canWinNim(2), is(true));
        assertThat(canWinNim(3), is(true));
        assertThat(canWinNim(4), is(false));
    }
}

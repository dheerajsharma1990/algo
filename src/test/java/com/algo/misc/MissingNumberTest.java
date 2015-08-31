package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MissingNumberTest {

    private final MissingNumber missingNumber = new MissingNumber();

    @Test
    public void shouldReturn2if2isMissing() {
        //then
        assertThat(missingNumber.missingNumber(new int[]{0, 1, 3}), is(2));
    }

    @Test
    public void shouldReturn1if1isMissing() {
        //then
        assertThat(missingNumber.missingNumber(new int[]{0}), is(1));
    }

}
package com.algo.misc;

import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class UglyNumberTest {

    private final UglyNumber uglyNumber = new UglyNumber();

    @Test
    public void shouldCollectAllUglyNumbersBetween0To100() {
        //when
        List<Integer> uglyNumbers = uglyNumber.uglyNumbers(1, 100);

        //then
        assertThat(uglyNumbers.size(), is(34));
    }

    @Test
    public void shouldHaveFalseFor0() {
        //then
        assertThat(uglyNumber.isUgly(0), is(false));
    }

    @Test
    public void shouldHaveTrueFor1() {
        //then
        assertThat(uglyNumber.isUgly(1), is(true));
    }

    @Test
    public void shouldHaveTrueFor24() {
        //then
        assertThat(uglyNumber.isUgly(24), is(true));
    }

    @Test
    public void shouldHaveFalseFor26() {
        //then
        assertThat(uglyNumber.isUgly(26), is(false));
    }

}
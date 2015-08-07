package com.algo.linkedlist;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MajorityElementTest {

    private final MajorityElement majorityElement = new MajorityElement();

    @Test
    public void shouldReturnMajorityElementForSingleElement() {
        assertThat(majorityElement.majorityElement(new int[]{1}), is(1));
    }

    @Test
    public void shouldReturnMajorityElementForMultipleElement() {
        assertThat(majorityElement.majorityElement(new int[]{2, 2, 1}), is(2));
    }

}

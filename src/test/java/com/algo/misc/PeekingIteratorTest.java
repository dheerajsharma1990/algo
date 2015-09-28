package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PeekingIteratorTest implements Iterator<Integer> {

    private Integer current;
    private Iterator<Integer> iterator;

    public PeekingIteratorTest() {
    }

    public PeekingIteratorTest(Iterator<Integer> iterator) {
        this.iterator = iterator;
        setCurrent(iterator);
    }

    private void setCurrent(Iterator<Integer> iterator) {
        this.current = iterator.hasNext() ? iterator.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return current;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int cur = current;
        setCurrent(iterator);
        return cur;
    }

    @Override
    public void remove() {
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Test
    public void shouldTestForSingleElement() {
        //given
        PeekingIteratorTest test = new PeekingIteratorTest(Arrays.asList(1).iterator());

        //then
        assertThat(test.peek(), is(1));
        assertThat(test.peek(), is(1));
        assertThat(test.hasNext(), is(true));
        assertThat(test.next(), is(1));
        assertThat(test.hasNext(), is(false));
    }

    @Test
    public void shouldTestForDoubleElement() {
        //given
        PeekingIteratorTest test = new PeekingIteratorTest(Arrays.asList(2, 1).iterator());

        //then
        assertThat(test.peek(), is(2));
        assertThat(test.peek(), is(2));
        assertThat(test.hasNext(), is(true));
        assertThat(test.next(), is(2));
        assertThat(test.peek(), is(1));
        assertThat(test.peek(), is(1));
        assertThat(test.hasNext(), is(true));
        assertThat(test.next(), is(1));
        assertThat(test.hasNext(), is(false));
    }

}

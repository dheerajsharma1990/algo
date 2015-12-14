package com.algo.stacks;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SortStackTest {

    public void sort(Stack<Integer> stack) {
        pop(stack);
    }

    private void pop(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int pop = stack.pop();
            pop(stack);
            sortAndPush(stack, pop);
        }
    }

    private void sortAndPush(Stack<Integer> stack, Integer element) {
        if (stack.isEmpty() || stack.peek() < element) {
            stack.push(element);
        } else {
            int pop = stack.pop();
            sortAndPush(stack, element);
            stack.push(pop);
        }
    }

    @Test
    public void shouldSortReverseSortedStackElements() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        sort(stack);
        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void shouldSortSortedStackElements() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        sort(stack);
        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }

    @Test
    public void shouldSortRandomStackElements() {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(9);
        stack.push(2);
        stack.push(5);

        sort(stack);
        assertThat(stack.pop(), is(9));
        assertThat(stack.pop(), is(7));
        assertThat(stack.pop(), is(5));
        assertThat(stack.pop(), is(4));
        assertThat(stack.pop(), is(3));
        assertThat(stack.pop(), is(2));
        assertThat(stack.pop(), is(1));
    }
}

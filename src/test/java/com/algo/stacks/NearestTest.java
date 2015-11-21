package com.algo.stacks;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class NearestTest {
    public List<Integer> prevSmaller(List<Integer> arr) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.size(); i++) {
            while (!stack.isEmpty() && arr.get(stack.peek()) >= arr.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                list.add(-1);
            } else {
                list.add(arr.get(stack.peek()));
            }
            stack.push(i);
        }
        return list;
    }

    @Test
    public void shouldSimplifyPaths() {
        assertThat(prevSmaller(Arrays.asList(4, 5, 2, 10)), hasItems(-1, 4, -1, 2));
        assertThat(prevSmaller(Arrays.asList(1)), hasItems(-1));
        assertThat(prevSmaller(Arrays.asList(1, 2)), hasItems(-1, 1));
        assertThat(prevSmaller(Arrays.asList(2, 1)), hasItems(-1, -1));
        assertThat(prevSmaller(Arrays.asList(2, 1, 2, 3)), hasItems(-1, -1, 1, 2));
        assertThat(prevSmaller(Arrays.asList(39, 27, 11, 4, 24, 32, 32, 1)), hasItems(-1, -1, -1, -1, 4, 24, 24, -1));
    }
}

package com.algo.stacks;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EvalExpTest {
    public int evalRPN(List<String> a) {
        Stack<Integer> stack = new Stack<>();
        for (String s : a) {
            if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
                stack.push(Integer.valueOf(s));
            } else {
                Integer second = stack.pop();
                Integer first = stack.pop();
                if (s.equals("+")) {
                    stack.push(first + second);
                } else if (s.equals("-")) {
                    stack.push(first - second);
                } else if (s.equals("*")) {
                    stack.push(first * second);
                } else {
                    stack.push(first / second);
                }
            }
        }
        return stack.pop();

    }

    @Test
    public void shouldSimplifyPaths() {
        assertThat(evalRPN(Arrays.asList("2", "1", "+", "3", "*")), is(9));
        assertThat(evalRPN(Arrays.asList("4", "13", "5", "/", "+")), is(6));
        assertThat(evalRPN(Arrays.asList("1", "2", "+")), is(3));
        assertThat(evalRPN(Arrays.asList("1", "2", "+")), is(3));

    }
}

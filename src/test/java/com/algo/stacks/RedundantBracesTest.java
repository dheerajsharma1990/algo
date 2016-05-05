package com.algo.stacks;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RedundantBracesTest {
    public int braces(String a) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : a.toCharArray()) {
            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                stack.push(ch);
            }
            if (ch == ')') {
                if (stack.peek() == '(') {
                    return 1;
                } else {
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();
                }
            }
        }
        return 0;
    }

    @Test
    public void shouldCheckForRedundantBraces() {
        assertThat(braces("((a+b))"), is(1));
        assertThat(braces("(a+(a+b))"), is(0));
        assertThat(braces("(a)"), is(1));
        assertThat(braces("(a+b)"), is(0));
        assertThat(braces("((a+b+c))"), is(1));
        assertThat(braces("((a+b)+(c+d))"), is(0));
        assertThat(braces("(((a+b)+(c+d)))"), is(1));
    }
}

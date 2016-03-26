package com.algo.stacks;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BalancedParenthesisTest {

    private boolean isBalanced(String string) {
        Stack<Character> stack = new Stack<>();
        for (Character character : string.toCharArray()) {
            if (character == '{' || character == '[' || character == '(') {
                stack.push(character);
            } else {
                if (character == '}') {
                    if (stack.empty() || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
                if (character == ']') {
                    if (stack.empty() || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
                if (character == ')') {
                    if (stack.empty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return stack.empty();
    }

    @Test
    public void shouldTestForVariousScenarios() {
        assertThat(isBalanced("a(bcd)d"), is(true));
        assertThat(isBalanced("(sfdsf)(fsfsf"), is(false));
        assertThat(isBalanced("{[]}()"), is(true));
        assertThat(isBalanced("{[}]"), is(false));
    }

}

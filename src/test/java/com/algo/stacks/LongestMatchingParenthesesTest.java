package com.algo.stacks;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LongestMatchingParenthesesTest {

    class Node {
        char ch;
        int index;

        public Node(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }

    class Range {
        int start;
        int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getCount() {
            return (end - start + 1);
        }
    }

    public int longestValidParentheses(String s) {
        Stack<Node> stack = new Stack<>();
        Stack<Range> ranges = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!stack.empty()) {
                    Node node = stack.pop();
                    Range range = new Range(node.index, i);
                    while (!ranges.empty() && ranges.peek().start > range.start && ranges.peek().end < range.end) {
                        ranges.pop();
                    }
                    if (!ranges.empty() && ranges.peek().end + 1 == range.start) {
                        Range pop = ranges.pop();
                        ranges.push(new Range(pop.start, range.end));
                    } else {
                        ranges.push(range);
                    }
                }
            } else {
                stack.push(new Node(c, i));
            }
        }
        int max = 0;
        while (!ranges.empty()) {
            Range range = ranges.pop();
            max = Math.max(max, range.getCount());
        }
        return max;
    }

    @Test
    public void shouldGetVariousRanges() {
        assertThat(longestValidParentheses("(()(())("), is(6));
        assertThat(longestValidParentheses("(()"), is(2));
        assertThat(longestValidParentheses(")()())"), is(4));
        assertThat(longestValidParentheses("())()"), is(2));
        assertThat(longestValidParentheses("())()"), is(2));
        assertThat(longestValidParentheses(")))"), is(0));
        assertThat(longestValidParentheses("((("), is(0));
        assertThat(longestValidParentheses("(())"), is(4));
        assertThat(longestValidParentheses("(())()(())"), is(10));
        assertThat(longestValidParentheses("(())())(())"), is(6));
        assertThat(longestValidParentheses("(())())(())(()())"), is(10));
    }
}

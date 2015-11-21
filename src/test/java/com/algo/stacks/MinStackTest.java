package com.algo.stacks;

import java.util.Stack;

public class MinStackTest {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStackTest() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            if (minStack.peek().equals(x)) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

}

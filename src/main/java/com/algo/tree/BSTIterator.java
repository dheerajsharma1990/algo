package com.algo.tree;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        populateLeftTree(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode x = stack.pop();
        populateLeftTree(x.getRight());
        return x.getValue();
    }

    private void populateLeftTree(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.getLeft();
        }
    }
}

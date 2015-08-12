package com.algo.tree;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.getLeft());
            invertTree(root.getRight());
            TreeNode mid = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(mid);
            return root;
        }
        return null;
    }
}

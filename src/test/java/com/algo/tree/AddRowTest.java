package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddRowTest {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode treeNode = new TreeNode(v);
            treeNode.left = root;
            return treeNode;
        }
        addRow(root, v, d, 2);
        return root;
    }

    private void addRow(TreeNode root, int v, int d, int i) {
        if(root!= null) {
            if (i == d) {
                TreeNode left = new TreeNode(v);
                TreeNode right = new TreeNode(v);
                left.left = root.left;
                right.right = root.right;
                root.left = left;
                root.right = right;
                return;
            }
            addRow(root.left, v, d, i + 1);
            addRow(root.right, v, d, i + 1);
        }
    }

}

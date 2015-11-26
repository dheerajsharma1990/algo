package com.algo.tree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class InOrderTreeTest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> answer = new ArrayList<>();
        if (a == null) {
            return answer;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = a;
        while (true) {
            while (x != null) {
                stack.push(x);
                x = x.left;
            }
            if (stack.empty()) {
                break;
            }
            x = stack.pop();
            answer.add(x.val);
            x = x.right;
        }
        return answer;
    }

    @Test
    public void shouldReturnInOrderForSingleNodeTree() {
        assertThat(inorderTraversal(new TreeNode(1)), hasItems(1));
    }

    @Test
    public void shouldReturnInOrderForAnyNodesTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        assertThat(inorderTraversal(root), hasItems(1, 2, 3, 4, 5));
    }

}

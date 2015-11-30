package com.algo.tree;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class NextPointerTest {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        while (root.left != null) {
            root.left.next = root.right;
            TreeLinkNode n = root.next;
            TreeLinkNode x = root;
            while (n != null) {
                x.right.next = n.left;
                n.left.next = n.right;
                x = n;
                n = n.next;
            }
            root = root.left;
        }
    }

    @Test
    public void shouldConnectNextNodesOfSingleNodeTree() {
        TreeLinkNode node = new TreeLinkNode(1);

        connect(node);

        assertThat(node.val, is(1));
        assertThat(node.next, nullValue());
    }

    @Test
    public void shouldConnectNextNodesOf1LevelPerfectTree() {
        TreeLinkNode node = new TreeLinkNode(1);
        node.left = new TreeLinkNode(2);
        node.right = new TreeLinkNode(3);


        connect(node);

        assertThat(node.val, is(1));
        assertThat(node.left.val, is(2));
        assertThat(node.left.next.val, is(3));
        assertThat(node.right.val, is(3));
        assertThat(node.left.next.next, nullValue());
    }

    @Test
    public void shouldConnectNextNodesOf2LevelPerfectTree() {
        TreeLinkNode node = new TreeLinkNode(1);
        node.left = new TreeLinkNode(2);
        node.right = new TreeLinkNode(3);
        node.left.left = new TreeLinkNode(4);
        node.left.right = new TreeLinkNode(5);
        node.right.left = new TreeLinkNode(6);
        node.right.right = new TreeLinkNode(7);


        connect(node);

        assertThat(node.val, is(1));
        assertThat(node.left.val, is(2));
        assertThat(node.left.next.val, is(3));
        assertThat(node.right.val, is(3));
        assertThat(node.left.left.next.val, is(5));
        assertThat(node.left.left.next.next.val, is(6));
        assertThat(node.left.left.next.next.next.val, is(7));

    }

    @Test
    public void shouldConnectNextNodesOf3LevelPerfectTree() {
        TreeLinkNode node = new TreeLinkNode(1);
        node.left = new TreeLinkNode(2);
        node.right = new TreeLinkNode(3);

        node.left.left = new TreeLinkNode(4);
        node.left.right = new TreeLinkNode(5);
        node.right.left = new TreeLinkNode(6);
        node.right.right = new TreeLinkNode(7);


        node.left.left.left = new TreeLinkNode(8);
        node.left.left.right = new TreeLinkNode(9);
        node.left.right.left = new TreeLinkNode(10);
        node.left.right.right = new TreeLinkNode(11);

        node.right.left.left = new TreeLinkNode(12);
        node.right.left.right = new TreeLinkNode(13);
        node.right.right.left = new TreeLinkNode(14);
        node.right.right.right = new TreeLinkNode(15);


        connect(node);

        assertThat(node.val, is(1));
        assertThat(node.left.val, is(2));
        assertThat(node.left.next.val, is(3));
        assertThat(node.right.val, is(3));
        assertThat(node.left.left.next.val, is(5));
        assertThat(node.left.left.next.next.val, is(6));
        assertThat(node.left.left.next.next.next.val, is(7));

    }
}

package com.algo.tree;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class PopulateNextRightTest {

    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root != null) {
            Queue<TreeLinkNode> queue = new ArrayDeque<>();
            queue.add(root);
            queue.add(new TreeLinkNode(Integer.MAX_VALUE));
            TreeLinkNode previous = null;
            while (true) {
                TreeLinkNode node = queue.poll();
                if (node.val == Integer.MAX_VALUE) {
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        previous = null;
                        queue.add(new TreeLinkNode(Integer.MAX_VALUE));
                    }
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (previous != null) {
                        previous.next = node;
                    }
                    previous = node;
                }
            }
        }
    }

    @Test
    public void shouldConnectNextNodeForSingleNode() {
        //given
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);

        //when
        connect(treeLinkNode);

        //then
        assertThat(treeLinkNode.left, nullValue());
        assertThat(treeLinkNode.right, nullValue());
        assertThat(treeLinkNode.next, nullValue());
    }

    @Test
    public void shouldConnectNextNodeForTwoNodes() {
        //given
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);

        //when
        connect(treeLinkNode);

        //then
        assertThat(treeLinkNode.right, nullValue());
        assertThat(treeLinkNode.next, nullValue());
        assertThat(treeLinkNode.left.left, nullValue());
        assertThat(treeLinkNode.left.right, nullValue());
        assertThat(treeLinkNode.left.next, nullValue());
    }

    @Test
    public void shouldConnectNextNodeForThreeNodes() {
        //given
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.right = new TreeLinkNode(3);

        //when
        connect(treeLinkNode);

        //then
        assertThat(treeLinkNode.next, nullValue());
        assertThat(treeLinkNode.left.left, nullValue());
        assertThat(treeLinkNode.left.right, nullValue());
        assertThat(treeLinkNode.left.next, notNullValue());
    }

    @Test
    public void shouldConnectNextNodeForSeveralNodes() {
        //given
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.right = new TreeLinkNode(3);
        treeLinkNode.left.left = new TreeLinkNode(4);
        treeLinkNode.left.right = new TreeLinkNode(5);
        treeLinkNode.right.right = new TreeLinkNode(7);


        //when
        connect(treeLinkNode);

        //then
        assertThat(treeLinkNode.next, nullValue());
        assertThat(treeLinkNode.left.next, notNullValue());
        assertThat(treeLinkNode.left.left.next, notNullValue());
        assertThat(treeLinkNode.left.right.next, notNullValue());
    }
}

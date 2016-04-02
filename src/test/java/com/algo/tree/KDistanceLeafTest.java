package com.algo.tree;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class KDistanceLeafTest {

    class Tree {
        int val;
        Tree left;
        Tree right;

        public Tree(int val) {
            this.val = val;
        }
    }

    private Set<Integer> printKDistanceTree(Tree root, int k) {
        Set<Integer> ans = new HashSet<>();
        kDistance(root, new ArrayList<Tree>(), ans, k);
        return ans;
    }

    private void kDistance(Tree root, List<Tree> path, Set<Integer> ans, int k) {
        if (root != null) {
            if (root.left == null && root.right == null && (path.size() - k) >= 0) {
                ans.add(path.get(path.size() - k).val);
            }
            path.add(root);
            kDistance(root.left, path, ans, k);
            kDistance(root.right, path, ans, k);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void shouldGetKDistanceNodes() {
        //given
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.right = new Tree(4);
        root.right.left = new Tree(9);

        root.left.left = new Tree(5);
        root.left.left.left = new Tree(8);
        root.left.left.right = new Tree(6);
        root.left.left.right.right = new Tree(7);

        root.right.left.left = new Tree(10);
        root.right.left.left.right = new Tree(11);
        root.right.left.left.right.left = new Tree(12);
        root.right.left.left.right.right = new Tree(13);

        //when
        Set<Integer> ans = printKDistanceTree(root, 2);

        //then
        assertThat(ans.size(), is(4));

    }


}

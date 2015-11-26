package com.algo.tree;

import org.testng.annotations.Test;
import sun.text.normalizer.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class UniquePrefixTest {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class CharNode {
        char ch;
        int count;
        CharNode[] nodes = new CharNode[26];

        public CharNode(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public ArrayList<String> prefix(List<String> a) {
        ArrayList<String> ans = new ArrayList<>();
        CharNode head = new CharNode('x', 0);
        CharNode root = head;
        for (String string : a) {
            for (char ch : string.toCharArray()) {
                if (root.nodes[ch - 'a'] == null) {
                    CharNode node = new CharNode(ch, 1);
                    root.nodes[ch - 'a'] = node;
                } else {
                    root.nodes[ch - 'a'].count++;
                }
                root = root.nodes[ch - 'a'];
            }
            root = head;
        }

        for (String string : a) {
            StringBuilder builder = new StringBuilder();
            for (char c : string.toCharArray()) {
                root = root.nodes[c - 'a'];
                builder.append(c);
                if (root.count == 1) {
                    break;
                }
            }
            root = head;
            ans.add(builder.toString());
        }

        return ans;
    }

    @Test
    public void shouldReturnValidUniquePrefix() {
        assertThat(prefix(Arrays.asList("dheeraj", "sharma", "dhiraj", "shama")), hasItems("dhe", "shar", "dhi", "sham"));
        assertThat(prefix(Arrays.asList("abc")), hasItems("a"));
        assertThat(prefix(Arrays.asList("abc", "pqr")), hasItems("a", "p"));
        assertThat(prefix(Arrays.asList("zebra", "dog", "duck", "dove")), hasItems("z", "dog", "du", "dov"));
    }


}

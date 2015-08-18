package com.algo.linkedlist;

import com.algo.tree.TreeNode;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RootToLeafPathTest {

    private final RootToLeafPath rootToLeafPath = new RootToLeafPath();

    @Test
    public void shouldHaveEmptyPathForNullTree() {
        //when
        List<String> paths = rootToLeafPath.binaryTreePaths(null);

        //then
        assertThat(paths.size(), is(0));
    }

    @Test
    public void shouldHaveSinglePathForSingleNodeTree() {
        //when
        List<String> paths = rootToLeafPath.binaryTreePaths(new TreeNode(1, null, null));

        //then
        assertThat(paths.size(), is(1));
        assertThat(paths.get(0), is("1"));
    }

    @Test
    public void shouldHaveSinglePathForLeftTree() {
        //when
        List<String> paths = rootToLeafPath.binaryTreePaths(new TreeNode(1, new TreeNode(2, null, null), null));

        //then
        assertThat(paths.size(), is(1));
        assertThat(paths.get(0), is("1->2"));
    }

    @Test
    public void shouldHaveTwoPathForCompleteLeftTree() {
        //when
        List<String> paths = rootToLeafPath.binaryTreePaths(new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)));

        //then
        assertThat(paths.size(), is(2));
        assertThat(paths.get(0), is("1->2"));
        assertThat(paths.get(1), is("1->3"));
    }

}
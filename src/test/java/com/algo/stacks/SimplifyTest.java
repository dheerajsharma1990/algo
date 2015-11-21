package com.algo.stacks;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimplifyTest {
    public String simplifyPath(String a) {
        a = a.replaceAll("/+", "/");
        a = a.substring(1);
        a = a.charAt(a.length() - 1) == '/' ? a : a + "/";
        String[] splits = a.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for (String split : splits) {
            if (split.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else if (!split.equals(".")) {
                deque.addLast(split);
            }
        }
        Iterator<String> iterator = deque.iterator();
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            builder.append("/").append(iterator.next());
        }
        String s = builder.toString();
        return s.isEmpty() ? "/" : s;
    }

    @Test
    public void shouldSimplifyPaths() {
        assertThat(simplifyPath("/..//"), is("/"));
        assertThat(simplifyPath("/home//foo"), is("/home/foo"));
        assertThat(simplifyPath("/../"), is("/"));
        assertThat(simplifyPath("/a/./b/../"), is("/a"));
        assertThat(simplifyPath("/a/./b/.."), is("/a"));
        assertThat(simplifyPath("/a/../../.."), is("/"));
        assertThat(simplifyPath("/a/b/c/de"), is("/a/b/c/de"));
        assertThat(simplifyPath("/./a/../../../de"), is("/de"));
        assertThat(simplifyPath("/./a/../de/../v"), is("/v"));
    }
}

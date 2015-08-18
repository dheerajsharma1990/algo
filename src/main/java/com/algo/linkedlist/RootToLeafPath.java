package com.algo.linkedlist;

import com.algo.tree.TreeNode;

import java.util.*;

public class RootToLeafPath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<>();
        addPaths(root, new LinkedList<String>(), allPaths);
        return allPaths;
    }

    private void addPaths(TreeNode root, Deque<String> paths, List<String> allPaths) {
        if (root != null) {
            paths.addLast(String.valueOf(root.getValue()));
            addPaths(root.getLeft(), paths, allPaths);
            addPaths(root.getRight(), paths, allPaths);
            if (isLeaf(root)) {
                allPaths.add(convertToPath(paths));
            }
            paths.removeLast();
        }
    }

    private String convertToPath(Deque<String> paths) {
        if (paths.size() == 1) {
            return paths.getFirst();
        } else {
            StringBuilder builder = new StringBuilder();
            Iterator<String> iterator = paths.iterator();
            builder.append(iterator.next());
            while (iterator.hasNext()) {
                builder.append("->").append(iterator.next());
            }
            return builder.toString();
        }
    }


    private boolean isLeaf(TreeNode root) {
        return root.getLeft() == null && root.getRight() == null;
    }
}

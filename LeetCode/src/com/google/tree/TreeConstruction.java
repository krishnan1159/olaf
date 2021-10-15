package com.google.tree;

import com.google.TreeNode;

public class TreeConstruction {
    public static TreeNode constructTree(Integer[] array) {
        return constructTreeInternal(array, 0);
    }

    private static TreeNode constructTreeInternal(Integer[] array, int index) {
        if (index < array.length) {
            final TreeNode leftNode = constructTreeInternal(array, ((index * 2) + 1));
            final TreeNode rightNode = constructTreeInternal(array, ((index * 2) + 2));
            return new TreeNode(array[index], leftNode, rightNode);
        }
        return null;
    }
}

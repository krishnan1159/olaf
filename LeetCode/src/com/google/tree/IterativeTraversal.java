package com.google.tree;

import com.google.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeTraversal {

    public static void inOrderTraversal(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.println("Tree is emtpy. Cannot do inorder traversal");
            return;
        }

        final Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(treeNode);
        while(!treeNodeQueue.isEmpty()) {
            treeNodeQueue.remove();
        }
    }

    public static void preOrderTraversal(TreeNode treeNode) {

    }

    public static void postOrderTraversal(TreeNode treeNode) {

    }

    public static void main(String[] args) {
        Integer[][] input = {{2,3,1,3,1,null,1}};
        for (int i = 0; i < input.length; i++) {
            System.out.print("Proccessing input :: " + i + " , ");
            final TreeNode completeTree = TreeConstruction.constructTree(input[i]);
            inOrderTraversal(completeTree);
            preOrderTraversal(completeTree);
            postOrderTraversal(completeTree);
        }
    }
}

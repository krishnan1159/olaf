package com.google.tree;

import com.google.TreeNode;

import java.util.concurrent.atomic.AtomicLong;

public class PseudoPalindromicPaths {
    int[] numCount = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int totalSum = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        int palindromeCount = 0;
        if (root == null) {
            return 0;
        }

        numCount[root.val]++;
        if (numCount[root.val] % 2 == 1) {
            totalSum++;
        } else {
            totalSum--;
        }

        if (root.left == null && root.right == null) {
            if (totalSum == 1 || totalSum == 0) {
                palindromeCount = 1;
            }
        }

        if (root.left != null) {
            palindromeCount += pseudoPalindromicPaths(root.left);
        }

        if (root.right != null) {
            palindromeCount += pseudoPalindromicPaths(root.right);
        }

        numCount[root.val]--;
        if (numCount[root.val] % 2 == 1) {
            totalSum++;
        } else {
            totalSum--;
        }

        return palindromeCount;
    }

}

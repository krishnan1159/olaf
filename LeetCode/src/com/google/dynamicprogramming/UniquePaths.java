package com.google.dynamicprogramming;

import java.io.IOException;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int rowIndex = 0; rowIndex < dp.length; rowIndex++) {
            Arrays.fill(dp[rowIndex], 0);
        }

        for(int rowIndex = 0; rowIndex < dp.length; rowIndex++) {
            for(int colIndex = 0; colIndex < dp[0].length; colIndex++) {
                if (rowIndex == 0 && colIndex == 0) {
                    dp[rowIndex][colIndex] = 0;
                } else if (rowIndex == 0 || colIndex == 0) {
                    dp[rowIndex][colIndex] = 1;
                } else {
                    dp[rowIndex][colIndex] = dp[rowIndex - 1][colIndex] + dp[rowIndex][colIndex - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) throws IOException {
        int m = 3;
        int n = 7;
        System.out.println("Result = " + uniquePaths(m, n));
    }
}

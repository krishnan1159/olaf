package com.google.dynamicprogramming;

import java.io.IOException;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/target-sum/
 */
public class TargetSum {

    private static int findAllWays(int[] nums, int index, int sum,
                                   int target, int[][] preComputeSum) {

        if (index == nums.length && sum == target) {
            return 1;
        }

        if (index < nums.length) {
            int countTargetPositive = findAllWays(nums, index + 1,
                    (sum + nums[index]), target, preComputeSum);
            int countTargetNegative = findAllWays(nums, index + 1,
                    (sum - nums[index]), target, preComputeSum);
            return countTargetPositive + countTargetNegative;
        }

        return 0;
    }

    private static int findTargetSumWays(int[] nums, int target) {
        int[][] preComputeSum = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(preComputeSum[i], -1001);
        }
        return findAllWays(nums, 0, 0, target, preComputeSum);
    }

    public static void main(String[] args) throws IOException {
        int[] input = new int[] {1,1,1,1,1};
        int target = 3;
        System.out.println("Result = " + findTargetSumWays(input, target));
    }
}

package com.google.dynamicprogramming;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {

    private static int findCost(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }

        int left = findCost(nums, index + 2);
        int right = findCost(nums, index + 3);
        return nums[index] + Math.max(left, right);
    }

    private static int findCostMemoization(int[] nums, int index, int[] precomputeCost) {
        if (index >= nums.length) {
            return 0;
        }

        int cost = precomputeCost[index];
        if (precomputeCost[index] == -1) {
            int left = findCostMemoization(nums, index + 2, precomputeCost);
            int right = findCostMemoization(nums, index + 3, precomputeCost);
            cost = nums[index] + Math.max(left, right);
            precomputeCost[index] = cost;
        }

        return cost;
    }

    private static int rob(int[] nums) {
        if (nums.length == 0) {
            return nums[0];
        }

        int[] precomputeCost = new int[nums.length];
        Arrays.fill(precomputeCost, -1);

        int res = Math.max(findCostMemoization(nums, 0, precomputeCost),
                findCostMemoization(nums, 1, precomputeCost));

        return res;
    }

    public static void main(String[] args) throws IOException {
        int[] input = new int[] {226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,
                54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,
                62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,
                180,249,106,37,169,225,54,103,55,166,124};
        System.out.println("Result = " + rob(input));
    }
}

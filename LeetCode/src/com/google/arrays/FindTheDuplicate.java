package com.google.arrays;

import java.io.IOException;

// https://leetcode.com/problems/find-the-duplicate-number/solution/
public class FindTheDuplicate {

    public static int findDuplicate(int[] nums) {
        int size = nums.length;
        int xor = 0, i = 1;
        for (; i < size; i++) {
            xor ^= i;
            xor ^= nums[i-1];
        }
        xor ^= nums[i-1];
        return xor;
    }
    public static void main(String[] args) throws IOException {

        int[][] input = {{1,3,4,2,2}};
        for (int i = 0; i < input.length; i++) {
            System.out.print("Processing input :: " + i + " , ");
            System.out.println(findDuplicate(input[i]));
        }
    }
}

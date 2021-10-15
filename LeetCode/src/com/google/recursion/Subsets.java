package com.google.recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * Time Complexity = N * 2^N
 * Space Complexity = N * 2^N
 */


public class Subsets {

    private static List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> emptyArray = new ArrayList<>();
        result.add(emptyArray);

        for (int i = 0; i < nums.length; i++) {
            int resultSize = result.size();
            for(int j = 0; j < resultSize; j++) {
                final List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        final int[] input = new int[]{1, 2, 3};

        final List<List<Integer>> result = subsets(input);

        for (final List<Integer> temp : result) {
            for (Integer integer : temp) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

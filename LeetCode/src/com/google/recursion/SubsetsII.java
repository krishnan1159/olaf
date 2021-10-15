package com.google.recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/subsets-ii/
 *
 *
 * Approaches 1:
 * Sort the array and while iteration write logic based on duplication.
 *
 * Approach 2: (Coded for this)
 * Maintain a hashmap to determine if the number is duplicated and decide based on that.
 */
public class SubsetsII {
    // Incorrect approach
    private static List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        final Map<Integer, Integer> countMap = new HashMap<>();
        final List<Integer> emptyArray = new ArrayList<>();
        result.add(emptyArray);

        for (int i = 0; i < nums.length; i++) {
            int resultSize = result.size();
            int skipArraySize = -1;
            if (countMap.containsKey(nums[i])) {
                final int tempCount = countMap.get(nums[i]);
                skipArraySize = tempCount - 1;
                countMap.put(nums[i], tempCount + 1);
            } else {
                countMap.put(nums[i], 1);
            }
            for(int j = 0; j < resultSize; j++) {
                final List<Integer> newList = new ArrayList<>(result.get(j));
                if (newList.size() != skipArraySize) {
                    newList.add(nums[i]);
                    result.add(newList);
                }
            }
        }

        return result;
    }

    private static List<List<Integer>> subsetsII(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> emptyArray = new ArrayList<>();
        result.add(emptyArray);

        Arrays.sort(nums);
        int skipArrayUpto = -1;
        for (int i = 0; i < nums.length; i++) {
            int resultOldSize = result.size();
            boolean skipArray = false;
            if (i > 0 && nums[i] == nums[i - 1]) {
                skipArray = true;
            }
            for(int j = 0; j < resultOldSize; j++) {
                final List<Integer> newList = new ArrayList<>(result.get(j));
                if (skipArray && j < skipArrayUpto)
                    continue;
                newList.add(nums[i]);
                result.add(newList);
            }

            skipArrayUpto = resultOldSize;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        final int[] input = new int[]{1, 1};

        final List<List<Integer>> result = subsetsII(input);

        for (final List<Integer> temp : result) {
            for (Integer integer : temp) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

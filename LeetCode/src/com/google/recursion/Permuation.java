package com.google.recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permuation {
    private static void collectAllPermutations(int[] nums, boolean[] visited,
                                               List<Integer> current,
                                               List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(current);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                final List<Integer> newList = new ArrayList<>(current);
                newList.add(nums[i]);
                visited[i] = true;
                collectAllPermutations(nums, visited, newList, result);
                visited[i] = false;
            }
        }
    }

    private static List<List<Integer>> permutation(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        final boolean[] visited = new boolean[nums.length];
        final List<Integer> current = new ArrayList<>();
        collectAllPermutations(nums, visited, current, result);

        return result;
    }

    public static void main(String[] args) throws IOException {
        final int[] input = new int[]{1, 2, 3};

        final List<List<Integer>> result = permutation(input);

        for (final List<Integer> temp : result) {
            for (Integer integer : temp) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

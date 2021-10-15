package com.google.recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 *
 * Note: See why you introduced lastElementIndex. Don't leave that mistake in interview.
 */
public class CombinationSum {

    private static void collectAllCombiSums(final int[] candidates, final int target,
                                            final int lastElementIndex,
                                            final List<Integer> current,
                                            final List<List<Integer>> result) {
        if (target == 0) {
            final List<Integer> finalList = new ArrayList<>(current);
            result.add(finalList);
            return;
        }

        for(int index = lastElementIndex; index < candidates.length; index++) {
            int remainingTarget = target - candidates[index];
            if ( remainingTarget >= 0 ) {
                current.add(candidates[index]);
                collectAllCombiSums(candidates, remainingTarget, index, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> current = new ArrayList<>();
        collectAllCombiSums(candidates, target, 0, current, result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        final int[] candidates = new int[]{2, 3, 6, 7};
        final int target = 7;

        final List<List<Integer>> result = combinationSum(candidates, target);

        for (final List<Integer> temp : result) {
            for (Integer integer : temp) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

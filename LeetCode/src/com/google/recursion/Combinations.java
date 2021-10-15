package com.google.recursion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private static void collectAllCombinations(int n, int k,
                                               List<Integer> current,
                                               List<List<Integer>> result) {
        if (k == 0) {
            final List<Integer> finalList = new ArrayList<>(current);
            result.add(finalList);
            return;
        }

        int startPos = 1;
        if (current.size() > 0) {
            startPos = current.get(current.size() - 1) + 1;
        }

        while (startPos <= n) {
            current.add(startPos);
            collectAllCombinations(n, k - 1, current, result);
            current.remove(current.size() - 1);
            startPos++;
        }
    }

    private static List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> current = new ArrayList<>();
        collectAllCombinations(n, k, current, result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        final int[] input = new int[] {4,4};
        final List<List<Integer>> result = combine(input[0], input[1]);

        for (final List<Integer> temp : result) {
            for (Integer integer : temp) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

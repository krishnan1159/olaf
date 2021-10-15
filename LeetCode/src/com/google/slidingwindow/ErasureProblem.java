package com.google.slidingwindow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ErasureProblem {
    public static int maximumUniqueSubarray(int[] nums) {
        final int[] sumArray = new int[nums.length];
        final Map<Integer, Integer> numIndexs = new HashMap<>();
        int startIndex = 0, maxSum = -1;
        for (int index = 0; index < nums.length; index++) {
            if (numIndexs.containsKey(nums[index])) {
                int numIndex = numIndexs.get(nums[index]);
                if ((numIndex + 1) > startIndex) {
                    startIndex = numIndex + 1;
                }
            }

            // Update sum array
            sumArray[index] = 0;
            if (index > 0) {
                sumArray[index] = sumArray[index - 1] + nums[index];
            } else {
                sumArray[index] = nums[index];
            }

            // Find local max
            int localMax = sumArray[index] - sumArray[startIndex] + nums[startIndex];
            if (localMax > maxSum) {
                maxSum = localMax;
            }
            numIndexs.put(nums[index], index);
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {

        int[][] input = {{5,2,1,2,5,2,1,2,5}};
        for (int i = 0; i < input.length; i++) {
            System.out.print("Proccessing input :: " + i + " , ");
            System.out.println(maximumUniqueSubarray(input[i]));
        }
    }
}

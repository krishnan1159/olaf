package com.google.dynamicprogramming;

import java.io.IOException;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaxProductSubarray {

    private static int maxProduct(int[] nums) {
        int [][] productMatrix = new int[nums.length][nums.length];
        int maxProduct = Integer.MIN_VALUE;

        // Initialize
        for (int index = 0; index < nums.length; index++) {
            Arrays.fill(productMatrix[index], 0);
        }

        for (int firstRowIndex = 0; firstRowIndex < nums.length; firstRowIndex++) {
            if (firstRowIndex == 0) {
                productMatrix[0][firstRowIndex] = nums[firstRowIndex];
            } else {
                productMatrix[0][firstRowIndex] = productMatrix[0][firstRowIndex - 1] * nums[firstRowIndex];
            }

            if (productMatrix[0][firstRowIndex] > maxProduct) {
                maxProduct = productMatrix[0][firstRowIndex];
            }
        }

        for (int rowIndex = 1; rowIndex < nums.length; rowIndex++) {
            for (int colIndex = rowIndex; colIndex < nums.length; colIndex++) {
                int leftProduct = productMatrix[0][colIndex - 1] != 0 ? productMatrix[0][colIndex - 1] : 1;
                int rightProduct = productMatrix[0][colIndex] != 0
                        ? productMatrix[0][nums.length - 1] / productMatrix[0][colIndex] : 1;

                productMatrix[rowIndex][colIndex] = productMatrix[0][nums.length - 1] / (leftProduct * rightProduct);

                if (productMatrix[rowIndex][colIndex] > maxProduct) {
                    maxProduct = productMatrix[rowIndex][colIndex];
                }
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) throws IOException {
        int[] input = new int[] {0, 2};
        System.out.println("Result = " + maxProduct(input));
    }
}

package com.google.adhoc;

import java.io.IOException;

public class SortColor {
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1, index = 0;
        while (mid <= high) {
            if (nums[low] == 0) {
                swap(mid, low, nums);
                low++;
                mid++;
            } else if (nums[low] == 1) {
                mid++;
            } else {
                swap(mid, high, nums);
                high--;
            }
        }

        while (index < nums.length) {
            System.out.print(nums[index] + " ");
            index++;
        }
        System.out.println();
    }

    private static void swap(int lindex, int rindex, int[] nums) {
        int temp = nums[lindex];
        nums[lindex] = nums[rindex];
        nums[rindex] = temp;
    }

    public static void main(String[] args) {

        int[][] input = {{2,0,2,1,1,0}};
        for (int i = 0; i < input.length; i++) {
            System.out.print("Proccessing input :: " + i + " , ");
            sortColors(input[i]);
        }
    }
}

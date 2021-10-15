package com.google.slidingwindow;

import java.io.IOException;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        return 1;
    }

    public static void main(String[] args) throws IOException {

        int[][] input = {{5,2,1,2,5,2,1,2,5}};
        for (int i = 0; i < input.length; i++) {
            System.out.print("Processing input :: " + i + " , ");
            System.out.println(threeSumClosest(input[i], 5));
        }
    }
}

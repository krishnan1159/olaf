package com.google.arrays;

import java.io.IOException;

public class ContainerWithWater {
    public static int maxArea(int[] height) {
        return 1;
    }

    public static void main(String[] args) throws IOException {

        int[][] input = {{5,2,1,2,5,2,1,2,5}};
        for (int i = 0; i < input.length; i++) {
            System.out.print("Processing input :: " + i + " , ");
            System.out.println(maxArea(input[i]));
        }
    }
}

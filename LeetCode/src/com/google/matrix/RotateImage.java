package com.google.matrix;

import java.io.IOException;
import java.util.List;

public class RotateImage {

    public static void rotate(int[][] matrix) {

    }

    public static void main(String[] args) throws IOException {

        //int[][] input = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        //int[][] input = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] input = {{1}};
        //int[][] input = {{1,2},{3,4}};
        //int[][] input = {{1,2,3,4}};
        //int[][] input = {{1},{2},{3},{4}};

        rotate(input);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}

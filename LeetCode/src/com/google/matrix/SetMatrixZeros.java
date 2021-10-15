package com.google.matrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeros {

    public static void setZeroes(int[][] matrix) {
        final int[] rowsToSetZero = new int[matrix.length];
        Arrays.fill(rowsToSetZero, 0);
        final int[] colsToSetZero = new int[matrix[0].length];
        Arrays.fill(colsToSetZero, 0);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsToSetZero[i] = 1;
                    colsToSetZero[j] = 1;
                }
            }
        }

        for (int i = 0; i < rowsToSetZero.length; i++) {
            if (rowsToSetZero[i] > 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < colsToSetZero.length; i++) {
            if (colsToSetZero[i] > 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //int[][] input = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        int[][] input = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(input);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}

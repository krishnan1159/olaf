package com.google.matrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        int startRowIndex = 0;
        int startColIndex = 0;
        int endRowIndex = matrix.length - 1;
        int endColIndex = matrix[0].length - 1;
        while (m > 0 && n > 0) {

            if (m == 1 || n == 1) {
                if (m == 1) {
                    for (int i = startColIndex; i <= endColIndex; i++) {
                        result.add(matrix[startRowIndex][i]);
                    }
                } else {
                    for (int i = startRowIndex; i <= endRowIndex; i++) {
                        result.add(matrix[i][startColIndex]);
                    }
                }
            } else {
                // top row
                for (int i = startColIndex; i < endColIndex; i++) {
                    result.add(matrix[startRowIndex][i]);
                }

                // right col
                for (int i = startRowIndex; i < endRowIndex; i++) {
                    result.add(matrix[i][endColIndex]);
                }

                // bottom row
                for (int i = endColIndex; i > startColIndex; i--) {
                    result.add(matrix[endRowIndex][i]);
                }

                // left col
                for (int i = endRowIndex; i > startRowIndex; i--) {
                    result.add(matrix[i][startColIndex]);
                }

                startRowIndex += 1;
                startColIndex += 1;
                endRowIndex -= 1;
                endColIndex -= 1;
            }

            m -= 2;
            n -= 2;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        //int[][] input = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        int[][] input = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
        //int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] input = {{1}};
        //int[][] input = {{1,2},{3,4}};
        //int[][] input = {{1,2,3,4}};
        //int[][] input = {{1},{2},{3},{4}};

        List<Integer> res = spiralOrder(input);

        for (int i = 0; i < res.size() - 1; i++) {
            System.out.print(res.get(i) + ", ");
        }
        System.out.print(res.get(res.size()-1));
    }
}

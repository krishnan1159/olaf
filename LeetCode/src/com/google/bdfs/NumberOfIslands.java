package com.google.bdfs;

import java.io.IOException;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    private static void dfs(char[][] grid, int rowIndex, int colIndex,
                            int rowSize, int colSize, boolean[][] visited) {
        // Boundary conditions
        // If the node in grid is already visited
        // If the node is a water node, we can skip visiting.
        if (rowIndex < 0 || rowIndex >= rowSize || colIndex < 0 || colIndex >= colSize
                || visited[rowIndex][colIndex] || grid[rowIndex][colIndex] == '0') {
            return;
        }

        visited[rowIndex][colIndex] = true;

        // Move right
        dfs(grid, rowIndex, colIndex + 1, rowSize, colSize, visited);

        // Move Left
        dfs(grid, rowIndex, colIndex - 1, rowSize, colSize, visited);

        // Move Up
        dfs(grid, rowIndex + 1, colIndex, rowSize, colSize, visited);

        // Move Down
        dfs(grid, rowIndex - 1, colIndex, rowSize, colSize, visited);
    }

    private static int numIslands(char[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int numIslands = 0;

        boolean[][] visited = new boolean[rowSize][colSize];
        for (int index = 0; index < rowSize; index++) {
            Arrays.fill(visited[index], false);
        }

        for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
            for (int colIndex = 0; colIndex < colSize; colIndex++) {
                if (grid[rowIndex][colIndex] == '1' && !visited[rowIndex][colIndex]) {
                    numIslands++;
                    dfs(grid, rowIndex, colIndex, rowSize, colSize, visited);
                }
            }
        }

        return numIslands;
    }

    public static void main(String[] args) throws IOException {

        //int[][] input = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        //int[][] input = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
        char[][] input = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};

        char[][] input1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        System.out.println("Res :: " + numIslands(input1));
    }
}

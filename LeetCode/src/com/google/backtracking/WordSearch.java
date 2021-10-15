package com.google.backtracking;

import java.io.IOException;
import java.util.Arrays;

// https://leetcode.com/problems/word-search/
public class WordSearch {

    private static boolean dfs(char[][] board, String word, int rowPos, int colPos,
                               int rowSize, int colSize, int wordPos, boolean[][] visited) {
        boolean res = false;
        if (rowPos >= 0 && colPos >= 0 && rowPos < rowSize && colPos < colSize && !visited[rowPos][colPos]) {
            visited[rowPos][colPos] = true;
            if (board[rowPos][colPos] == word.charAt(wordPos)) {
                if (wordPos == word.length() -1 ) {
                    return true;
                }
                // Go Right
                res |= dfs(board, word, rowPos, colPos + 1, rowSize, colSize,
                        wordPos + 1, visited);
                // Go left
                res |= dfs(board, word, rowPos, colPos - 1, rowSize, colSize,
                        wordPos + 1, visited);
                // Go Up
                res |= dfs(board, word, rowPos - 1, colPos, rowSize, colSize,
                        wordPos + 1, visited);
                // Go Down
                res |= dfs(board, word, rowPos + 1, colPos, rowSize, colSize,
                        wordPos + 1, visited);
            }
            visited[rowPos][colPos] = false;
        }

        return res;
    }

    private static void initializeVisited(boolean[][] visited) {
        for (int i = 0 ; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public static boolean exist(char[][] board, String word) {
        if (word == null) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        // initial value will be false.
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                    boolean localRes = dfs(board, word, i, j, rows, cols, 0, visited);
                    if (localRes) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println("Result :: " + exist(board, word));
    }
}

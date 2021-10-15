package com.google.backtracking;

import java.io.IOException;

public class BeautifulPattern {

    static int count = 0;

    public static int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        calculate(n, 1, visited);
        return count;
    }

    public static void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int[][] input = {{5,2,1,2,5,2,1,2,5}};
        for (int i = 0; i < input.length; i++) {
            System.out.print("Processing input :: " + i + " , ");
            System.out.println(countArrangement(3 ));
        }
    }
}

package boj15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static boolean[] visited;
    private static int[] memory;

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        visited = new boolean[n + 1];
        memory = new int[n + 1];

        backtracking(n, m, 1, 0);
    }

    private static void backtracking(int n, int m, int start, int count) {
        if (count == m) {
            for (int value : memory) {
                if (value != 0) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n + 1; i++) {
            if (!visited[i] || i == start) {
                visited[i] = true;
                memory[count] = i;
                backtracking(n, m, i, count + 1);
                visited[i] = false;
            }
        }
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

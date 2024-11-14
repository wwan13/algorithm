package boj10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] memory;
    private static boolean[] visited;

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        memory = new int[n];
        visited = new boolean[n + 1];

        backTracking(n, 1, 0);
    }

    private static void backTracking(int n, int current, int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(memory[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                memory[depth] = i;
                backTracking(n, i, depth + 1);
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

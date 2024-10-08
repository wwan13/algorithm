package boj15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) {
        String[] line = readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        visited = new boolean[n + 1];
        arr = new int[n + 1];

        dfs(n, m, 0);
    }

    private static void dfs(int n, int m, int depth) {
        if (depth == m) {
            for (int value : arr) {
                if (value != 0) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;

                dfs(n, m, depth + 1);

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

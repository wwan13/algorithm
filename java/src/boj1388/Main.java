package boj1388;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        char[][] data = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            data[i] = readLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, data, visited);
                    count += 1;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(
            int x,
            int y,
            char[][] data,
            boolean[][] visited
    ) {
        visited[x][y] = true;

        if (data[x][y] == '-') {
            if (y + 1 < data[0].length && data[x][y + 1] == '-' && !visited[x][y + 1]) {
                dfs(x, y + 1, data, visited);
            }
        }

        if (data[x][y] == '|') {
            if (x + 1 < data.length && data[x + 1][y] == '|' && !visited[x + 1][y]) {
                dfs(x + 1, y, data, visited);
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

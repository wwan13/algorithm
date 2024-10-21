package boj16929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static char[][] data;
    private static boolean[][] visited;
    private static boolean isCycled;

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        data = new char[n][m];
        for (int i = 0; i < n; i++) {
            data[i] = readLine().toCharArray();
        }

        isCycled = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                dfs(i, j, i, j, data[i][j], 1);
                if (isCycled) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    private static void dfs(int x, int y, int firstX, int firstY, char target, int count) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < data.length && ny >= 0 && ny < data[0].length && data[nx][ny] == target) {
                if (!visited[nx][ny]) {
                    dfs(nx, ny, firstX, firstY, target, count + 1);
                } else {
                    if (count >= 4 && nx == firstX && ny == firstY) {
                        isCycled = true;
                        return;
                    }
                }
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

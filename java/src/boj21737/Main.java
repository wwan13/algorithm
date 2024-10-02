package boj21737;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    private static final char EMPTY = 'O';
    private static final char WALL = 'X';
    private static final char DOYEON = 'I';
    private static final char PERSON = 'P';

    private static final String FAIL = "TT";

    public static void main(String[] args) {
        String[] nk = readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int startX = -1;
        int startY = -1;

        char[][] data = new char[n][k];
        for (int i = 0; i < n; i++) {
            char[] parsed = readLine().toCharArray();
            for (int j = 0; j < k; j++) {
                data[i][j] = parsed[j];
                if (data[i][j] == DOYEON) {
                    startX = i;
                    startY = j;
                }
            }
        }

        boolean[][] visited = new boolean[n][k];

        int result = dfs(startX, startY, data, visited);

        if (result == 0) {
            System.out.println(FAIL);
            return;
        }

        System.out.println(result);
    }

    private static int dfs(
            int x,
            int y,
            char[][] data,
            boolean[][] visited
    ) {
        visited[x][y] = true;
        int count = 0;

        if (data[x][y] == PERSON) {
            count += 1;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < data.length && ny >= 0 && ny < data[0].length && !visited[nx][ny] && data[nx][ny] != WALL) {
                count += dfs(nx, ny, data, visited);
            }
        }

        return count;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

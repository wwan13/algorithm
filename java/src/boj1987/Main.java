package boj1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    private static char[][] map;
    private static int maxCount;
    private static boolean[] alphabetVisited;

    public static void main(String[] args) {
        final String[] rc = readLine().split(" ");
        final int r = Integer.parseInt(rc[0]);
        final int c = Integer.parseInt(rc[1]);

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = readLine().toCharArray();
        }

        alphabetVisited = new boolean[26];
        maxCount = -1;

        dfs(0, 0, 1);

        System.out.println(maxCount);
    }

    private static void dfs(int x, int y, int count) {
        alphabetVisited[map[x][y] - 'A'] = true;
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + DX[i];
            int ny = y + DY[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length &&
                    !alphabetVisited[map[nx][ny] - 'A']) {
                dfs(nx, ny, count + 1);
            }
        }

        alphabetVisited[map[x][y] - 'A'] = false;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

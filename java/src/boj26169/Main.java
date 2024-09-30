package boj26169;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int APPLE = 1;
    private static final int HURDLE = -1;
    private static final int NORMAL = 0;

    private static final int SUCCESS = 1;
    private static final int FAIL = 0;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] data = new int[5][5];
        for (int i = 0; i < 5; i++) {
            data[i] = Arrays.stream(readLine().split(" ")).
                    mapToInt(Integer::parseInt)
                    .toArray();
        }

        String[] rc = readLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);

        int result = dfs(r, c, data, 0, 0);

        System.out.println(result);
    }

    private static int dfs(
            int x,
            int y,
            int[][] data,
            int moveCount,
            int appleCount
    ) {
        if (data[x][y] == APPLE) {
            appleCount += 1;
        }

        if (appleCount >= 2) {
            return SUCCESS;
        }

        if (moveCount == 3) {
            return FAIL;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || data[nx][ny] == HURDLE) {
                continue;
            }

            data[x][y] = HURDLE;
            if (dfs(nx, ny, data, moveCount + 1, appleCount) == SUCCESS) {
                return SUCCESS;
            }
            data[x][y] = NORMAL;
        }

        return FAIL;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

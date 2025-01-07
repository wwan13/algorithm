package boj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int[][] tomatoes;

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        tomatoes = new int[m][n];
        for (int i = 0; i < m; i++) {
            tomatoes[i] = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        if (isSuccess()) {
            System.out.println(0);
            return;
        }

        int result = bfs(m, n);

        if (isSuccess()) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs(int m, int n) {
        Queue<int[]> queue = new LinkedList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tomatoes[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && tomatoes[nx][ny] == 0) {
                        tomatoes[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            days += 1;
        }

        return days - 1;
    }

    private static boolean isSuccess() {
        for (int[] tomato : tomatoes) {
            for (int j = 0; j < tomatoes[0].length; j++) {
                if (tomato[j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

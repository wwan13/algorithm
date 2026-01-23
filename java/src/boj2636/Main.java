package boj2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int time = 0;
        int prevCount = 0;

        boolean[][] visited = new boolean[n][m];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        while (true) {
            int cheeseCount = countCheese(map, n, m);
            if (cheeseCount == 0) break;

            prevCount = cheeseCount;
            time++;

            // visited 초기화
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            queue.clear();
            queue.add(new int[]{0, 0});
            visited[0][0] = true;

            List<int[]> meltList = new ArrayList<>();

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (visited[nx][ny]) continue;

                    visited[nx][ny] = true;

                    if (map[nx][ny] == 1) {
                        meltList.add(new int[]{nx, ny});
                    } else {
                        queue.add(new int[]{nx, ny});
                    }
                }
            }

            // 한 번에 녹이기
            for (int[] pos : meltList) {
                map[pos[0]][pos[1]] = 0;
            }
        }

        System.out.println(time);
        System.out.println(prevCount);
    }

    private static int countCheese(int[][] map, int n, int m) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) sum++;
            }
        }
        return sum;
    }
}
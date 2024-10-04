package boj2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        final int n = Integer.parseInt(readLine());

        String[] startEnd = readLine().split(" ");
        final int start = Integer.parseInt(startEnd[0]);
        final int end = Integer.parseInt(startEnd[1]);

        final int m = Integer.parseInt(readLine());

        final boolean[][] relations = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] xy = readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            relations[x][y] = true;
            relations[y][x] = true;
        }

        final boolean[] visited = new boolean[n + 1];
        final int[] distance = new int[n + 1];

        final Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == end) {
                System.out.println(distance[now]);
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (relations[now][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    distance[i] = distance[now] + 1;
                }
            }
        }

        System.out.println(-1);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

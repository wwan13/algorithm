package boj5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    static class Record {
        final int x;
        final int y;

        Record(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            String[] line = reader.readLine().split(" ");
            int w = Integer.parseInt(line[0]);
            int h = Integer.parseInt(line[1]);

            char[][] buildings = new char[h][w];

            Queue<Record> fireQueue = new ArrayDeque<>();
            Queue<Record> personQueue = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String row = reader.readLine();
                buildings[i] = row.toCharArray();
                for (int j = 0; j < w; j++) {
                    if (buildings[i][j] == '@') {
                        personQueue.add(new Record(i, j));
                    } else if (buildings[i][j] == '*') {
                        fireQueue.add(new Record(i, j));
                    }
                }
            }

            int[][] fireTime = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) fireTime[i][j] = -1;
            }

            for (Record f : fireQueue) {
                fireTime[f.x][f.y] = 0;
            }

            while (!fireQueue.isEmpty()) {
                Record current = fireQueue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = current.x + dx[d];
                    int ny = current.y + dy[d];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (buildings[nx][ny] == '#') continue;
                    if (fireTime[nx][ny] != -1) continue;

                    fireTime[nx][ny] = fireTime[current.x][current.y] + 1;
                    fireQueue.add(new Record(nx, ny));
                }
            }

            boolean[][] visited = new boolean[h][w];
            int[][] time = new int[h][w];
            boolean escaped = false;

            Record first = personQueue.peek();
            time[first.x][first.y] = 0;

            while (!personQueue.isEmpty() && !escaped) {
                Record cur = personQueue.poll();

                // 탈출
                if (cur.x == 0 || cur.x == h - 1 || cur.y == 0 || cur.y == w - 1) {
                    System.out.println(time[cur.x][cur.y] + 1);
                    escaped = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = cur.x + dx[d];
                    int ny = cur.y + dy[d];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (visited[nx][ny]) continue;
                    if (buildings[nx][ny] == '#') continue;

                    int nextTime = time[cur.x][cur.y] + 1;
                    if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= nextTime) continue;

                    visited[nx][ny] = true;
                    time[nx][ny] = nextTime;
                    personQueue.add(new Record(nx, ny));
                }
            }

            if (!escaped) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
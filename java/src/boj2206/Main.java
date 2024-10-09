package boj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int WALL = 1;
    private static final int NOT_BROKEN = 0;
    private static final int BROKEN = 1;
    private static final int[] DX = {1, -1, 0, 0};
    private static final int[] DY = {0, 0, 1, -1};

    private static int[][] map;
    private static boolean[][][] visited;

    static class Point {
        final int x;
        final int y;
        final int brokenStatus;

        Point(int x, int y, int brokenStatus) {
            this.x = x;
            this.y = y;
            this.brokenStatus = brokenStatus;
        }
    }

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        final int n = Integer.parseInt(nm[0]);
        final int m = Integer.parseInt(nm[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[n][m][2];

        Point start = new Point(0, 0, NOT_BROKEN);
        int answer = bfs(start);

        System.out.println(answer);
    }

    private static int bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y][0] = true;

        int xSize = map.length;
        int ySize = map[0].length;

        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                if (current.x == xSize - 1 && current.y == ySize - 1) {
                    return count;
                }

                for (int j = 0; j < 4; j++) {
                    final int nx = current.x + DX[j];
                    final int ny = current.y + DY[j];

                    if (nx >= 0 && nx < xSize && ny >= 0 && ny < ySize) {
                        if (map[nx][ny] == WALL && current.brokenStatus == NOT_BROKEN && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.offer(new Point(nx, ny, BROKEN));
                        }

                        if (map[nx][ny] != WALL && !visited[nx][ny][current.brokenStatus]) {
                            visited[nx][ny][current.brokenStatus] = true;
                            queue.offer(new Point(nx, ny, current.brokenStatus));
                        }
                    }
                }
            }
            count++;
        }

        return -1;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

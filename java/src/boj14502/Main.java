package boj14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};

    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;

    private static int[][] map;
    private static int[][] copiedMap;
    private static List<Point> virusPoints;
    private static int maxSafeArea;

    static class Point {
        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        map = new int[n][m];
        copiedMap = new int[n][m];
        virusPoints = new ArrayList<>();
        maxSafeArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j];

                if (map[i][j] == VIRUS) {
                    virusPoints.add(new Point(i, j));
                }
            }
        }

        buildWalls(0);

        System.out.println(maxSafeArea);
    }

    private static void buildWalls(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == EMPTY) {
                    map[i][j] = WALL;
                    buildWalls(count + 1);
                    map[i][j] = EMPTY;
                }
            }
        }
    }

    private static void spreadVirus() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }

        Queue<Point> queue = new LinkedList<>();
        for (Point point : virusPoints) {
            queue.offer(point);
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + DX[i];
                int ny = current.y + DY[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && copiedMap[nx][ny] == EMPTY) {
                    copiedMap[nx][ny] = VIRUS;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        calculateSafeArea();
    }

    private static void calculateSafeArea() {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (copiedMap[i][j] == EMPTY) {
                    count++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, count);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

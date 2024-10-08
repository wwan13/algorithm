package boj15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int EMPTY = 0;
    private static final int HOUSE = 1;
    private static final int CHICKEN = 2;

    private static int[][] map;
    private static boolean[] open;
    private static List<Point> chickens;
    private static List<Point> houses;
    private static int result;

    static class Point {
        final int x;
        final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        final String[] nm = readLine().split(" ");
        final int n = Integer.parseInt(nm[0]);
        final int m = Integer.parseInt(nm[1]);

        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            final int[] line = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = line[j];
                if (line[j] == CHICKEN) {
                    chickens.add(new Point(i, j));
                }
                if (line[j] == HOUSE) {
                    houses.add(new Point(i, j));
                }
            }
        }

        open = new boolean[chickens.size()];
        result = Integer.MAX_VALUE;

        dfs(0, m, 0);

        System.out.println(result);
    }

    private static void dfs(int openSize, int max, int count) {
        if (count == max) {
            int chickenDistance = 0;

            for (int i = 0; i < houses.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(houses.get(i).x - chickens.get(j).x) +
                                Math.abs(houses.get(i).y - chickens.get(j).y);

                        min = Math.min(min, distance);
                    }
                }
                chickenDistance += min;
            }

            result = Math.min(result, chickenDistance);
            return;
        }

        for (int i = openSize; i < chickens.size(); i++) {
            open[i] = true;
            dfs(i + 1, max, count + 1);
            open[i] = false;
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

package boj10216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Enemy {
        final int x;
        final int y;
        final int range;

        Enemy(int x, int y, int range) {
            this.x = x;
            this.y = y;
            this.range = range;
        }
    }

    private static int[] parents;

    public static void main(String[] args) {
        int t = Integer.parseInt(readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(readLine());

            parents = new int[n];
            Enemy[] enemies = new Enemy[n];
            for (int i = 0; i < n; i++) {
                String[] line = readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                int range = Integer.parseInt(line[2]);

                enemies[i] = new Enemy(x, y, range);
                parents[i] = i;
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isConnected(enemies[i], enemies[j])) {
                        union(i, j);
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (parents[i] == i) {
                    count += 1;
                }
            }

            System.out.println(count);
        }
    }

    private static boolean isConnected(Enemy e1, Enemy e2) {
        int dx = e2.x - e1.x;
        int dy = e2.y - e1.y;
        int range = e1.range + e2.range;
        return (dx * dx + dy * dy) <= range * range;
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parents[rootY] = parents[rootX];
        }
    }

    private static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

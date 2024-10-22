package boj1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] parents;

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int m = Integer.parseInt(readLine());

        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            String[] line = readLine().split(" ");
            for (int j = 1; j < n + 1; j++) {
                int value = Integer.parseInt(line[j - 1]);
                if (value == 1) {
                    union(i, j);
                }
            }
        }

        int[] plans = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstCity = find(plans[0]);

        boolean isPossible = true;
        for (int i = 1; i < m; i++) {
            if (firstCity != find(plans[i])) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }

        return parents[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parents[rootX] = parents[rootY];
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

package boj16562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] parents;

    public static void main(String[] args) {
        String[] nmk = readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        int[] moneys = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            String[] vw = readLine().split(" ");
            int v = Integer.parseInt(vw[0]);
            int w = Integer.parseInt(vw[1]);
            union(v, w);
        }

        Map<Integer, Integer> minCost = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int root = find(i);
            minCost.put(root, Math.min(minCost.getOrDefault(root, Integer.MAX_VALUE), moneys[i - 1]));
        }

        int totalCost = minCost.values().stream()
                .mapToInt(Integer::intValue).sum();

        if (totalCost <= k) {
            System.out.println(totalCost);
        } else {
            System.out.println("Oh no");
        }
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

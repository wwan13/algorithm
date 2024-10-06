package boj11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] parents;
    private static List<List<Integer>> tree;

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        parents = new int[n + 1];
        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int[] points = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            tree.get(points[0]).add(points[1]);
            tree.get(points[1]).add(points[0]);
        }

        boolean[] visited = new boolean[n + 1];
        dfs(1, visited);

        for (int i = 2; i < n + 1; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int current, boolean[] visited) {
        visited[current] = true;

        for (Integer next : tree.get(current)) {
            if (!visited[next]) {
                parents[next] = current;
                dfs(next, visited);
            }
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

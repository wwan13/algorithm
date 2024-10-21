package boj20955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Integer>> tree;
    private static boolean[] visited;
    private static int cycleCount;
    private static int componentCount;

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);

            tree.get(start).add(to);
            tree.get(to).add(start);
        }

        visited = new boolean[n + 1];
        cycleCount = 0;
        componentCount = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, -1);
                componentCount += 1;
            }
        }

        int result = (cycleCount / 2) + componentCount - 1;
        System.out.println(result);
    }

    private static void dfs(int current, int prev) {
        visited[current] = true;

        for (int next : tree.get(current)) {
            if (next == prev) {
                continue;
            }
            if (!visited[next]) {
                dfs(next, current);
            } else {
                cycleCount += 1;
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

package boj2617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Integer>> heavyTree;
    private static List<List<Integer>> lightTree;
    private static boolean[] visited;
    private static int depth;

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        heavyTree = new ArrayList<>();
        lightTree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            heavyTree.add(new ArrayList<>());
            lightTree.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = readLine().split(" ");
            int heavier = Integer.parseInt(line[0]);
            int lighter = Integer.parseInt(line[1]);
            heavyTree.get(heavier).add(lighter);
            lightTree.get(lighter).add(heavier);
        }

        int count = 0;

        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            depth = 0;
            Arrays.fill(visited, false);
            dfs(heavyTree, i);
            if (depth > (n + 1) / 2) {
                count += 1;
            }

            depth = 0;
            Arrays.fill(visited, false);
            dfs(lightTree, i);
            if (depth > (n + 1) / 2) {
                count += 1;
            }
        }

        System.out.println(count);
    }

    private static void dfs(List<List<Integer>> tree, int current) {
        visited[current] = true;
        depth += 1;

        for (int next : tree.get(current)) {
            if (!visited[next]) {
                dfs(tree, next);
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

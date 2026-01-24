package boj15681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static List<List<Integer>> tree;
    static boolean[] visited;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int q = Integer.parseInt(line[2]);

        tree = new ArrayList<>();
        visited = new boolean[n + 1];
        map = new HashMap<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] treeLine = reader.readLine().split(" ");
            int start = Integer.parseInt(treeLine[0]);
            int to = Integer.parseInt(treeLine[1]);

            tree.get(start).add(to);
            tree.get(to).add(start);
        }

        dfs(r);

        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(reader.readLine());
            System.out.println(map.get(query));
        }
    }

    private static int dfs(int current) {
        visited[current] = true;
        int sum = 1;

        for (int next : tree.get(current)) {
            if (visited[next]) continue;
            sum += dfs(next);
        }

        map.put(current, sum);
        return sum;
    }
}

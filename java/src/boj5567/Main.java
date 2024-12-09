package boj5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Integer>> tree;
    private static boolean[] visited;

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int m = Integer.parseInt(readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = readLine().split(" ");
            int to = Integer.parseInt(line[0]);
            int from = Integer.parseInt(line[1]);

            tree.get(to).add(from);
            tree.get(from).add(to);
        }
        visited = new boolean[n + 1];
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int depth = 0;
        int count = 0;

        while (!queue.isEmpty() && depth < 2) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int next : tree.get(current)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

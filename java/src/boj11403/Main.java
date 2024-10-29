package boj11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Integer>> tree = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        tree = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] line = readLine().split(" ");

            for (int j = 0; j < n; j++) {
                if (line[j].equals("1")) {
                    tree.get(i).add(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited, false);
                sb.append(bfs(i, j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : tree.get(current)) {
                if (next == target) {
                    return 1;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return 0;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package boj1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Integer>> tree;
    private static int[] depth;
    private static boolean[] visited;

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

        depth = new int[n + 1];
        visited = new boolean[n + 1];

        int answer = 0;
        int minDepth = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(depth, 0);
            Arrays.fill(visited, false);
            bfs(i);

            int depthCount = 0;
            for (int d : depth) {
                depthCount += d;
            }

            if (depthCount < minDepth) {
                answer = i;
                minDepth = depthCount;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : tree.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[current] + 1;
                    queue.offer(next);
                }
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

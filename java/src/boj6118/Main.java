package boj6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] firstLine = readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edge = readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] distances = bfs(graph, n);

        int maxDistance = 0;
        int minNode = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (distances[i] > maxDistance) {
                maxDistance = distances[i];
                minNode = i;
                count = 1;
            } else if (distances[i] == maxDistance) {
                minNode = Math.min(minNode, i);
                count++;
            }
        }

        System.out.println(minNode + " " + maxDistance + " " + count);
    }

    private static int[] bfs(List<List<Integer>> graph, int n) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distances[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return distances;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

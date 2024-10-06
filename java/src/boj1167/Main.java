package boj1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> tree;
    private static boolean[] visited;
    private static int maxDistance = 0;
    private static int farthestNode = 0;

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int[] lines = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(it -> it != -1)
                    .toArray();

            for (int j = 1; j < lines.length; j += 2) {
                tree.get(lines[0]).add(new Node(lines[j], lines[j + 1]));
                tree.get(lines[j]).add(new Node(lines[0], lines[j + 1]));
            }
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        maxDistance = 0;
        visited = new boolean[n + 1];
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    private static void dfs(
            int current,
            int distance
    ) {
        visited[current] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = current;
        }

        for (Node node : tree.get(current)) {
            if (!visited[node.getTo()]) {
                dfs(node.getTo(), distance + node.getDistance());
            }
        }
    }

    static class Node {
        final int to;
        final int distance;

        Node(int i, int distance) {
            to = i;
            this.distance = distance;
        }

        public int getTo() {
            return to;
        }

        public int getDistance() {
            return distance;
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

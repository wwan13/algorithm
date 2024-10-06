package boj1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> tree;
    private static int maxDistance = 0;
    private static int farthestNode = 0;

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] parentChildWeight = readLine().split(" ");
            int parent = Integer.parseInt(parentChildWeight[0]);
            int child = Integer.parseInt(parentChildWeight[1]);
            int weight = Integer.parseInt(parentChildWeight[2]);

            tree.get(parent).add(new Node(child, weight));
            tree.get(child).add(new Node(parent, weight));
        }

        dfs(1, -1, 0);

        maxDistance = 0;
        dfs(farthestNode, -1, 0);

        System.out.println(maxDistance);
    }

    private static void dfs(
            int current,
            int parent,
            int distance
    ) {
        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = current;
        }

        tree.get(current).forEach(it -> {
            if (it.getTo() != parent) {
                dfs(it.getTo(), current, distance + it.getWeight());
            }
        });
    }

    static class Node {
        final int to;
        final int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
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

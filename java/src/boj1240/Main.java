package boj1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> tree;
    private static int[] distances;

    static class Node {
        final int to;
        final int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] line = readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);

            tree.get(start).add(new Node(to, weight));
            tree.get(to).add(new Node(start, weight));
        }

        distances = new int[n + 1];

        for (int i = 0; i < m; i++) {
            String[] line = readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);

            Arrays.fill(distances, Integer.MAX_VALUE);
            dijkstra(start);
            System.out.println(distances[to]);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(it -> it.weight));
        distances[start] = 0;
        priorityQueue.offer(new Node(start, 0));

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            for (Node node : tree.get(current.to)) {
                int nextDistance = node.weight + current.weight;
                if (nextDistance < distances[node.to]) {
                    distances[node.to] = nextDistance;
                    priorityQueue.offer(new Node(node.to, nextDistance));
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

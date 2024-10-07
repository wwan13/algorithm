package boj1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> tree;
    private static int[] weights;

    public static void main(String[] args) {
        final String[] ve = readLine().split(" ");
        final int v = Integer.parseInt(ve[0]);
        final int e = Integer.parseInt(ve[1]);

        final int k = Integer.parseInt(readLine());

        tree = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            final String[] line = readLine().split(" ");
            final int start = Integer.parseInt(line[0]);
            final int to = Integer.parseInt(line[1]);
            final int weight = Integer.parseInt(line[2]);

            tree.get(start).add(new Node(to, weight));
            tree.get(to).add(new Node(to, weight));
        }

        weights = new int[v + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);
        dijkstra(k);
        for (int i = 1; i < v + 1; i++) {
            if (k == i) {
                System.out.println(0);
                continue;
            }
            if (weights[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(weights[i]);
        }
    }

    static class Node {
        final int to;
        final int weight;

        Node(int i, int weight) {
            to = i;
            this.weight = weight;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(it -> it.weight));
        priorityQueue.offer(new Node(start, 0));
        weights[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            for (Node node : tree.get(current.to)) {
                int nextWeight = current.weight + node.weight;

                if (nextWeight < weights[node.to]) {
                    weights[node.to] = nextWeight;
                    priorityQueue.offer(new Node(node.to, nextWeight));
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

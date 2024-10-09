package boj14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> tree;
    private static int[] distance;
    private static boolean[] visited;

    static class Node {
        final int to;
        final int distance;

        Node(int i, int distance) {
            to = i;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        final String[] nmr = readLine().split(" ");
        final int n = Integer.parseInt(nmr[0]);
        final int m = Integer.parseInt(nmr[1]);
        final int r = Integer.parseInt(nmr[2]);

        final int[] items = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            final String[] line = readLine().split(" ");
            final int start = Integer.parseInt(line[0]);
            final int to = Integer.parseInt(line[1]);
            final int distance = Integer.parseInt(line[2]);

            tree.get(start).add(new Node(to, distance));
            tree.get(to).add(new Node(start, distance));
        }

        distance = new int[n + 1];
        visited = new boolean[n + 1];

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(distance, Integer.MAX_VALUE);
            dijkstra(i);

            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                if (distance[j] <= m) {
                    sum += items[j - 1];
                }
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(it -> it.distance));
        priorityQueue.offer(new Node(start, 0));

        distance[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (!visited[current.to]) {
                for (Node neighbor : tree.get(current.to)) {
                    int nextDistance = current.distance + neighbor.distance;
                    if (nextDistance < distance[neighbor.to]) {
                        distance[neighbor.to] = nextDistance;
                        priorityQueue.offer(new Node(neighbor.to, nextDistance));
                    }
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

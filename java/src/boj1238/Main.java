package boj1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> tree;
    private static int[] times;

    public static void main(String[] args) {
        final String[] nmx = readLine().split(" ");
        final int n = Integer.parseInt(nmx[0]);
        final int m = Integer.parseInt(nmx[1]);
        final int x = Integer.parseInt(nmx[2]);

        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            final String[] line = readLine().split(" ");
            final int start = Integer.parseInt(line[0]);
            final int to = Integer.parseInt(line[1]);
            final int time = Integer.parseInt(line[2]);

            tree.get(start).add(new Node(to, time));
        }

        int max = -1;
        times = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(times, Integer.MAX_VALUE);
            int time = 0;

            dijkstra(i);
            time += times[x];

            Arrays.fill(times, Integer.MAX_VALUE);
            dijkstra(x);
            time += times[i];

            max = Math.max(max, time);
        }

        System.out.println(max);
    }

    private static void dijkstra(int start) {
        times[start] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(it -> it.time));
        priorityQueue.offer(new Node(start, 0));

        while(!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            for (Node node : tree.get(current.to)) {
                int nextTime = current.time + node.time;
                if (nextTime < times[node.to]) {
                    priorityQueue.offer(new Node(node.to, nextTime));
                    times[node.to] = nextTime;
                }
            }
        }
    }

    static class Node {
        final int to;
        final int time;

        Node(int i, int weight) {
            to = i;
            this.time = weight;
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

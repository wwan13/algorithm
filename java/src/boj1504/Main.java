package boj1504;

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
        final int distance;

        Node(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        String[] ne = readLine().split(" ");
        int n = Integer.parseInt(ne[0]);
        int e = Integer.parseInt(ne[1]);

        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String[] line = readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            tree.get(a).add(new Node(b, c));
            tree.get(b).add(new Node(a, c));
        }

        String[] uv = readLine().split(" ");
        int u = Integer.parseInt(uv[0]);
        int v = Integer.parseInt(uv[1]);

        distances = new int[n + 1];

        long uvPath = 0;
        uvPath += calculateDistance(1, u);
        uvPath += calculateDistance(u, v);
        uvPath += calculateDistance(v, n);

        long vuPath = 0;
        vuPath += calculateDistance(1, v);
        vuPath += calculateDistance(v, u);
        vuPath += calculateDistance(u, n);

        long answer = Math.min(uvPath, vuPath);

        if (answer >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int calculateDistance(int start, int to) {
        Arrays.fill(distances, Integer.MAX_VALUE);
        dijkstra(start);
        return distances[to];
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(it -> it.distance));
        pq.offer(new Node(start, 0));
        distances[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node next : tree.get(current.to)) {
                int nextDistance = current.distance + next.distance;
                if (nextDistance < distances[next.to]) {
                    distances[next.to] = nextDistance;
                    pq.offer(new Node(next.to, nextDistance));
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

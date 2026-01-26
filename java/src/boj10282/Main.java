package boj10282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Node {
        final int to;
        final int distance;

        Node(int i, int distance) {
            to = i;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            String[] ndc = reader.readLine().split(" ");
            int n = Integer.parseInt(ndc[0]);
            int d = Integer.parseInt(ndc[1]);
            int c = Integer.parseInt(ndc[2]);

            List<List<Node>> tree = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                tree.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                String[] row = reader.readLine().split(" ");
                int a = Integer.parseInt(row[0]);
                int b = Integer.parseInt(row[1]);
                int s = Integer.parseInt(row[2]);

                tree.get(b).add(new Node(a, s));
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing((node) -> node.distance));
            int[] dist = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                dist[i] = Integer.MAX_VALUE;
            }

            pq.add(new Node(c, 0));
            dist[c] = 0;

            while (!pq.isEmpty()) {
                Node current = pq.poll();

                if (current.distance > dist[current.to]) continue;

                for (Node next : tree.get(current.to)) {
                    int nextDist = next.distance + current.distance;
                    int nextTo = next.to;

                    if (nextDist < dist[nextTo]) {
                        dist[nextTo] = nextDist;
                        pq.add(new Node(nextTo, nextDist));
                    }
                }
            }

            int max = Integer.MIN_VALUE;
            int count = 0;
            for (int i = 1; i < n + 1; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    count += 1;
                    max = Math.max(max, dist[i]);
                }
            }

            System.out.printf("%d %d\n", count, max);
        }
    }
}

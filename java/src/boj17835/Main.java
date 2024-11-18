package boj17835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        final int to;
        final long distance;

        Node(int to, long distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    private static List<List<Node>> reverseGraph;
    private static long[] distances;

    public static void main(String[] args) {
        String[] nmk = readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        reverseGraph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = readLine().split(" ");
            int from = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            long distance = Long.parseLong(line[2]);

            reverseGraph.get(to).add(new Node(from, distance));
        }

        int[] interviews = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        distances = new long[n + 1];
        Arrays.fill(distances, Long.MAX_VALUE);

        dijkstra(interviews);

        int answerNumber = -1;
        long answerDistance = -1;

        for (int i = 1; i <= n; i++) {
            if (distances[i] != Long.MAX_VALUE && distances[i] > answerDistance) {
                answerNumber = i;
                answerDistance = distances[i];
            }
        }

        System.out.println(answerNumber);
        System.out.println(answerDistance);
    }

    private static void dijkstra(int[] starts) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(node -> node.distance));
        for (int start : starts) {
            pq.offer(new Node(start, 0));
            distances[start] = 0;
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.distance > distances[current.to]) continue;

            for (Node next : reverseGraph.get(current.to)) {
                long nextDistance = distances[current.to] + next.distance;
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

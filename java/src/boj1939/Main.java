package boj1939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> tree;
    private static boolean[] visited;

    static class Node {
        final int to;
        final long weight;

        Node(int to, long weight) {
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

        long maxWeight = Long.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            String[] line = readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            long weight = Long.parseLong(line[2]);

            tree.get(start).add(new Node(to, weight));
            tree.get(to).add(new Node(start, weight));

            maxWeight = Math.max(maxWeight, weight);
        }

        String[] line = readLine().split(" ");
        int start = Integer.parseInt(line[0]);
        int to = Integer.parseInt(line[1]);

        long left = 1;
        long right = maxWeight;
        long answer = 0;
        visited = new boolean[n + 1];

        while (left <= right) {
            Arrays.fill(visited, false);

            long weight = (left + right) / 2;

            if (bfs(start, to, weight)) {
                answer = weight;
                left = weight + 1;
            } else {
                right = weight - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean bfs(int start, int to, long weight) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == to) {
                return true;
            }

            for (Node next : tree.get(current)) {
                if (!visited[next.to] && next.weight >= weight) {
                    visited[next.to] = true;
                    queue.offer(next.to);
                }
            }
        }

        return false;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

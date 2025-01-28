package boj1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int MAX = 100000;

    static class Node {
        int position;
        int count;

        public Node(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        if (n == m) {
            System.out.println(0);
        } else {
            System.out.println(bfs(n, m));
        }
    }

    private static int bfs(int start, int target) {
        boolean[] visited = new boolean[MAX + 1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        visited[start] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int position = current.position;
            int count = current.count;

            if (position == target) {
                return count;
            }

            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && !visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, count + 1));
                }
            }
        }

        return -1;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

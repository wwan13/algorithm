package boj2665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static class Node {
        final int x;
        final int y;
        final int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing((node) -> node.cost));

        dist[0][0] = 0;
        pq.add(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.x][cur.y]) continue;

            if (cur.x == n - 1 && cur.y == n - 1) {
                System.out.println(cur.cost);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || nx >= n) continue;
                if (ny < 0 || ny >= n) continue;

                int add = (map[nx][ny] == '0') ? 1 : 0;
                int nextCost = cur.cost + add;

                if (nextCost < dist[nx][ny]) {
                    dist[nx][ny] = nextCost;
                    pq.add(new Node(nx, ny, nextCost));
                }
            }
        }
    }
}
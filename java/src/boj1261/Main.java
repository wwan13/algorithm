package boj1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static char[][] map;
    private static int[][] brokenCount;

    static class Node {
        int x;
        int y;
        int brokenCount;

        public Node(int x, int y, int brokenCount) {
            this.x = x;
            this.y = y;
            this.brokenCount = brokenCount;
        }
    }

    public static void main(String[] args) {
        String[] mn = readLine().split(" ");
        int n = Integer.parseInt(mn[1]);
        int m = Integer.parseInt(mn[0]);

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = readLine().toCharArray();
        }

        brokenCount = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                brokenCount[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int startX, int startY) {
        int n = map.length;
        int m = map[0].length;

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startX, startY, 0));
        brokenCount[startX][startY] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == n - 1 && current.y == m - 1) {
                return current.brokenCount;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nextBrokenCount = current.brokenCount;
                    if (map[nx][ny] == '1') {
                        nextBrokenCount += 1;
                    }

                    if (nextBrokenCount < brokenCount[nx][ny]) {
                        brokenCount[nx][ny] = nextBrokenCount;

                        if (map[nx][ny] == '0') {
                            queue.offerFirst(new Node(nx, ny, nextBrokenCount));
                        } else if (map[nx][ny] == '1') {
                            queue.offerLast(new Node(nx, ny, nextBrokenCount));
                        }
                    }
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

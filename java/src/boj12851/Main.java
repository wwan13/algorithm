package boj12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] times;
    private static int minTime;
    private static int count;

    static class Node {
        final int to;
        final int time;

        Node(int i, int time) {
            to = i;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        times = new int[100001];
        Arrays.fill(times, Integer.MAX_VALUE);
        count = 0;
        minTime = Integer.MAX_VALUE;

        bfs(n, m);

        System.out.println(minTime);
        System.out.println(count);
    }

    private static void bfs(int start, int to) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));
        times[start] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.to == to) {
                if (current.time < minTime) {
                    minTime = current.time;
                    count = 1;
                } else if (current.time == minTime) {
                    count += 1;
                }
            }

            int[] nextPoints = {current.to + 1, current.to - 1, current.to * 2};
            for (int point : nextPoints) {
                if (point >= 0 && point < 100001) {
                    if (current.time + 1 <= times[point]) {
                        times[point] = current.time + 1;
                        queue.offer(new Node(point, current.time + 1));
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

package boj13549;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] times;

    static class Node {
        final int to;
        final int time;

        Node(int i, int time) {
            to = i;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        String[] nk = readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);


        times = new int[100001];
        Arrays.fill(times, Integer.MAX_VALUE);

        dijkstra(n);

        System.out.println(times[k]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(it -> it.time));
        priorityQueue.offer(new Node(start, 0));
        times[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            // case 1
            int nextTo = current.to + 1;
            int nextTime = current.time + 1;
            if (nextTo < times.length && nextTo >= 0 && nextTime < times[nextTo]) {
                priorityQueue.offer(new Node(nextTo, nextTime));
                times[nextTo] = nextTime;
            }


            // case 2
            nextTo = current.to - 1;
            nextTime = current.time + 1;
            if (nextTo < times.length && nextTo >= 0 && nextTime < times[nextTo]) {
                priorityQueue.offer(new Node(nextTo, nextTime));
                times[nextTo] = nextTime;
            }

            // case 3
            nextTo = current.to * 2;
            nextTime = current.time;
            if (nextTo < times.length && nextTo >= 0 && nextTime < times[nextTo]) {
                priorityQueue.offer(new Node(nextTo, nextTime));
                times[nextTo] = nextTime;
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

package boj14248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<List<int[]>> tree = new ArrayList<>();
        int[] dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            String[] abc = reader.readLine().split(" ");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);

            tree.get(a).add(new int[]{b, c});
            tree.get(b).add(new int[]{a, c});
        }

        String[] st = reader.readLine().split(" ");
        int s = Integer.parseInt(st[0]);
        int t = Integer.parseInt(st[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] it) -> it[1]));
        pq.add(new int[]{s, 0});
        dist[s] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (current[1] > dist[current[0]]) {
                continue;
            }

            for (int[] next : tree.get(current[0])) {
                int nextTo = next[0];
                int nextDist = current[1] + next[1];

                if (nextDist < dist[nextTo]) {
                    pq.add(new int[]{nextTo, nextDist});
                    dist[nextTo] = nextDist;
                }
            }
        }

        System.out.println(dist[t]);
    }
}

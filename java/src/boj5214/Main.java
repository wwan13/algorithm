package boj5214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nkm = reader.readLine().split(" ");
        int n = Integer.parseInt(nkm[0]);
        int k = Integer.parseInt(nkm[1]);
        int m = Integer.parseInt(nkm[2]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n + m; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            String[] line = reader.readLine().split(" ");
            int tubeNode = n + i;

            for (String station : line) {
                int stationNum = Integer.parseInt(station);
                graph.get(stationNum).add(tubeNode);
                graph.get(tubeNode).add(stationNum);
            }
        }

        System.out.println(bfs(graph, n, m));
    }

    private static int bfs(List<List<Integer>> graph, int n, int m) {
        boolean[] visitedStation = new boolean[n + 1];
        boolean[] visitedTube = new boolean[n + m + 1];
        Queue<int[]> queue = new LinkedList<>();

        visitedStation[1] = true;
        queue.add(new int[]{1, 1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int count = current[1];

            if (node == n) {
                return count;
            }

            for (int next : graph.get(node)) {
                if (next <= n && !visitedStation[next]) {
                    visitedStation[next] = true;
                    queue.add(new int[]{next, count + 1});
                } else if (next > n && !visitedTube[next]) {
                    visitedTube[next] = true;
                    queue.add(new int[]{next, count});
                }
            }
        }

        return -1;
    }
}

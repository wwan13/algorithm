package boj1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        final int start;
        final int to;
        final int weight;

        Node(int u, int v, int weight) {
            this.start = u;
            this.to = v;
            this.weight = weight;
        }
    }

    private static int[] parents;

    public static void main(String[] args) {
        String[] ve = readLine().split(" ");
        int v = Integer.parseInt(ve[0]);
        int e = Integer.parseInt(ve[1]);

        List<Node> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            String[] line = readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int to = Integer.parseInt(line[1]);
            int weight = Integer.parseInt(line[2]);
            edges.add(new Node(start, to, weight));
        }

        Collections.sort(edges, Comparator.comparing(it -> it.weight));

        parents = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parents[i] = i;
        }

        int mstWeight = 0;
        int edgeCount = 0;

        for (Node edge : edges) {
            if (union(edge.start, edge.to)) {
                mstWeight += edge.weight;
                edgeCount++;
                if (edgeCount == v - 1) {
                    break;
                }
            }
        }

        System.out.println(mstWeight);
    }

    private static boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parents[rootY] = rootX;
            return true;
        }
        return false;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

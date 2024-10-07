package boj1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> tree;
    private static int[] price;

    public static void main(String[] args) {
        final int n = Integer.parseInt(readLine());
        final int m = Integer.parseInt(readLine());

        price = new int[n + 1];
        Arrays.fill(price, Integer.MAX_VALUE);

        tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            final int[] lines = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            final int start = lines[0];
            final int to = lines[1];
            final int price = lines[2];

            tree.get(start).add(new Node(to, price));
        }

        final int[] lines = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int start = lines[0];
        final int target = lines[1];

        dijkstra(start);

        System.out.println(price[target]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.price));
        priorityQueue.offer(new Node(start, 0));
        price[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            int currentCity = current.to;
            int currentPrice = current.price;

            if (currentPrice > price[currentCity]) {
                continue;
            }

            for (Node neighbor : tree.get(currentCity)) {
                int toPrice = currentPrice + neighbor.price;

                if (toPrice < price[neighbor.to]) {
                    price[neighbor.to] = toPrice;
                    priorityQueue.offer(new Node(neighbor.to, toPrice));
                }
            }
        }
    }

    static class Node {
        final int to;
        final int price;

        public Node(int to, int price) {
            this.to = to;
            this.price = price;
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

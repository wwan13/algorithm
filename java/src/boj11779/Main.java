package boj11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static List<List<Node>> tree;
    private static int[] price;
    private static int[] previous;

    public static void main(String[] args) {
        final int n = Integer.parseInt(readLine());
        final int m = Integer.parseInt(readLine());

        price = new int[n + 1];
        Arrays.fill(price, Integer.MAX_VALUE);

        previous = new int[n + 1];
        Arrays.fill(previous, -1);

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

        List<Integer> path = new ArrayList<>();
        for (int at = target; at != -1; at = previous[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println(path.size());
        for (int node : path) {
            System.out.print(node + " ");
        }
    }

    static class Node {
        final int to;
        final int price;

        public Node(int to, int price) {
            this.to = to;
            this.price = price;
        }

        public int getTo() {
            return to;
        }

        public int getPrice() {
            return price;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(Node::getPrice));
        priorityQueue.offer(new Node(start, 0));
        price[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            if (current.price > price[current.to]) {
                continue;
            }

            for (Node node : tree.get(current.to)) {
                int nextPrice = node.price + current.price;
                if (nextPrice < price[node.to]) {
                    previous[node.to] = current.to;
                    price[node.to] = nextPrice;
                    priorityQueue.offer(new Node(node.to, nextPrice));
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

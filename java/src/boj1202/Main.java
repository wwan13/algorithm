package boj1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Jewel {
        final int weight;
        final int price;

        Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        String[] nk = readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        Jewel[] jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            String[] line = readLine().split(" ");
            int weight = Integer.parseInt(line[0]);
            int price = Integer.parseInt(line[1]);
            jewels[i] = new Jewel(weight, price);
        }
        Arrays.sort(jewels, Comparator.comparing(Jewel::getWeight));

        int[] bags = IntStream.range(0, k)
                .map(it -> Integer.parseInt(readLine()))
                .sorted()
                .toArray();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;
        long answer = 0;

        for (int bag : bags) {

            while (index < n && jewels[index].weight <= bag) {
                pq.offer(jewels[index].price);
                index += 1;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package boj11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Absolute {
        final int value;
        final int original;

        Absolute(int value, int original) {
            this.value = value;
            this.original = original;
        }

        public int getValue() {
            return value;
        }

        public int getOriginal() {
            return original;
        }

        static Absolute of(int value) {
            return new Absolute(Math.abs(value), value);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        PriorityQueue<Absolute> pq = new PriorityQueue<>(
                Comparator.comparing(Absolute::getValue).thenComparing(Absolute::getOriginal)
        );

        for (int i = 0; i < n; i++) {
            int command = Integer.parseInt(readLine());

            if (command == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().original);
                }
            } else {
                pq.offer(Absolute.of(command));
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

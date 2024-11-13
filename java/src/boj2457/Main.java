package boj2457;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Flower {
        final int start;
        final int end;

        Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        List<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = readLine().split(" ");
            flowers.add(
                    new Flower(
                            Integer.parseInt(line[0]) * 100 + Integer.parseInt(line[1]),
                            Integer.parseInt(line[2]) * 100 + Integer.parseInt(line[3])
                    )
            );
        }

        flowers.sort(Comparator.comparing(Flower::getStart)
                .thenComparing(Flower::getEnd, Comparator.reverseOrder()));

        int current = 301;
        int end = 1130;
        int count = 0;
        int maxEnd = 0;
        int index = 0;

        while (current <= end) {
            boolean found = false;
            while (index < n && flowers.get(index).start <= current) {
                maxEnd = Math.max(maxEnd, flowers.get(index).end);
                index++;
                found = true;
            }

            if (!found) {
                break;
            }

            count++;
            current = maxEnd;
        }

        if (maxEnd <= end) {
            System.out.println(0);
        } else {
            System.out.println(count);
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

package boj20920;

import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            counter.merge(readLine(), 1, Integer::sum);
        }

        counter.entrySet().stream()
                .filter(it -> it.getKey().length() >= m)
                .sorted(
                        Comparator.comparing(Map.Entry<String, Integer>::getValue, Comparator.reverseOrder())
                                .thenComparing(it -> it.getKey().length(), Comparator.reverseOrder())
                                .thenComparing(Map.Entry::getKey)
                )
                .map(Map.Entry::getKey)
                .forEach(it -> write(it + "\n"));

        flush();
        close();
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(String value) {
        try {
            writer.write(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void flush() {
        try {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void close() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

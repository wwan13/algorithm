package boj1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        Map<String, Integer> data = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String book = readLine();
            data.put(book, data.getOrDefault(book, 0) + 1);
        }

        int max = data.values().stream()
                .max(Comparator.comparing(it -> it))
                .orElse(0);

        String maxBook = data.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .sorted()
                .findFirst()
                .orElseThrow(IllegalStateException::new);

        System.out.println(maxBook);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

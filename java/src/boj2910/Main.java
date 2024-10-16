package boj2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nc = readLine().split(" ");
        int n = Integer.parseInt(nc[0]);
        int c = Integer.parseInt(nc[1]);

        String[] data = readLine().split(" ");

        Map<Integer, Integer> numberCount = new HashMap<>();
        Map<Integer, Integer> orders = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(data[i]);
            numberCount.put(number, numberCount.getOrDefault(number, 0) + 1);
            orders.putIfAbsent(number, i);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(numberCount.entrySet());

        entries.sort((a, b) -> {
            int freqA = a.getValue();
            int freqB = b.getValue();
            if (freqA != freqB) {
                return freqB - freqA;
            } else {
                return orders.get(a.getKey()) - orders.get(b.getKey());
            }
        });

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.append(number).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

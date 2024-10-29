package boj11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        Map<Long, Integer> cards = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long card = Long.parseLong(readLine());
            cards.put(card, cards.getOrDefault(card, 0) + 1);
        }

        List<Map.Entry<Long, Integer>> cardList = new ArrayList<>(cards.entrySet());
        Long result = cardList.stream()
                .sorted(Map.Entry.<Long, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey))
                .findFirst()
                .get()
                .getKey();

        System.out.println(result);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

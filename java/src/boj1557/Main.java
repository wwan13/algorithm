package boj1557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        char[] data = Console.readArray();
        char answer = solution(data);
        displayResult(answer);
    }

    public static char solution(char[] data) {
        Map<Character, Integer> count = new HashMap<>();

        for (char it : data) {
            char target = Character.toUpperCase(it);
            if (!count.containsKey(target)) {
                count.put(target, 0);
            }
            count.compute(target, (key, value) -> value += 1);
        }

        List<Character> sortedCount = count.keySet().stream()
                .sorted(Comparator.comparing(count::get).reversed())
                .collect(Collectors.toList());

        if (sortedCount.size() == 1) {
            return sortedCount.get(0);
        }

        if (count.get(sortedCount.get(0)) == count.get(sortedCount.get(1))) {
            return '?';
        }

        return sortedCount.get(0);
    }

    public static void displayResult(char answer) {
        System.out.println(answer);
    }

    public static class Console {

        private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static char[] readArray() {
            String line = Console.readLine();
            char[] data = new char[line.length()];
            for (int i = 0; i < line.length(); i++) {
                data[i] = line.charAt(i);
            }
            return data;
        }
    }
}

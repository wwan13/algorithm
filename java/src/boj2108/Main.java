package boj2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int n = Console.nextInt();
        int[] data = new int[n];

        IntStream.range(0, n)
                .forEach(i -> data[i] = Console.nextInt());

        int[] answer = solution(n, data);
        displayResult(answer);
    }

    public static int[] solution(int n, int[] data) {
        int[] answer = new int[4];

        answer[0] = Math.round((float) IntStream.of(data).sum() / data.length);
        answer[1] = IntStream.of(data).sorted().toArray()[data.length / 2];

        Map<Integer, Integer> count = new HashMap<>();
        for(int e : data) {
            if (!count.containsKey(e)) {
                count.put(e, 0);
            }
            count.compute(e, (key, value) -> value += 1);
        }
        List<Integer> sortedKeys = count.keySet().stream()
                .sorted(Comparator.comparing(count::get).reversed())
                .collect(Collectors.toList());

        List<Integer> maxKeys = sortedKeys.stream()
                .filter(it -> count.get(it).equals(count.get(sortedKeys.get(0))))
                .sorted()
                .collect(Collectors.toList());

        answer[2] = maxKeys.get(0);
        if (maxKeys.size() > 1) {
            answer[2] = maxKeys.get(1);
        }

        int max = IntStream.of(data).max().getAsInt();
        int min = IntStream.of(data).min().getAsInt();
        answer[3] = max - min;

        return answer;
    }

    public static void displayResult(int[] answer) {
        for (int e : answer) {
            System.out.println(e);
        }
    }

    public static class Console {

        private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static int nextInt() {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package boj2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] data;
    private static boolean[] visited;
    private static Set<Integer> finished;
    private static Set<Integer> answer;

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        data = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            data[i] = Integer.parseInt(readLine());
        }

        visited = new boolean[n + 1];
        finished = new HashSet<>();
        answer = new HashSet<>();

        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        System.out.println(answer.size());
        answer.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void dfs(int current) {
        visited[current] = true;

        int next = data[current];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished.contains(next)) {
            int value = next;
            while (value != current) {
                answer.add(value);
                value = data[value];
            }
            answer.add(value);
        }

        finished.add(current);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

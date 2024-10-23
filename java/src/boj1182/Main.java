package boj1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] data;
    private static int[] memory;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) {
        String[] ns = readLine().split(" ");
        int n = Integer.parseInt(ns[0]);
        int s = Integer.parseInt(ns[1]);

        data = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        memory = new int[n];
        count = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(memory, 0);
            backtracking(i, n, s, i);
        }

        System.out.println(count);
    }

    private static void backtracking(int start, int n, int s, int current) {
        memory[start] += 1;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (memory[i] != 0) {
                sum += data[i];
            }
        }
        if (sum == s) {
            count += 1;
        }

        for (int i = current + 1; i < n; i++) {
            memory[i] += 1;
            backtracking(start, n, s, i);
            memory[i] -= 1;
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

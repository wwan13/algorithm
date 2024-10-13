package boj15666;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] data;
    private static int[] memory;

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        data = new int[n];
        data = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .distinct()
                .sorted()
                .toArray();

        memory = new int[m + 1];

        backTracking(m, 0, 0);
    }

    private static void backTracking(int m, int count, int start) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                if (memory[i] != 0) {
                    System.out.print(memory[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < data.length; i++) {
            memory[count] = data[i];
            backTracking(m, count + 1, i);
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

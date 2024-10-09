package boj15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static boolean[] visited;
    private static int[] memory;

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        final int n = Integer.parseInt(nm[0]);
        final int m = Integer.parseInt(nm[1]);
        final int[] data = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        visited = new boolean[n + 1];
        memory = new int[n + 1];

        backTracking(data, m, 0);
    }

    private static void backTracking(int[] data, int m, int count) {
        if (count == m) {
            for (int value : memory) {
                if (value != 0) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < data.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                memory[count] = data[i];
                backTracking(data, m, count + 1);
                visited[i] = false;
            }
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

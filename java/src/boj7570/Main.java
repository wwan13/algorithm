package boj7570;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] data = new int[n + 1];
        String[] line = readLine().split(" ");
        for (int i = 0; i < n; i++) {
            data[Integer.parseInt(line[i])] = i;
        }

        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (data[i] > data[i - 1]) {
                count += 1;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }

        System.out.println(n - max);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

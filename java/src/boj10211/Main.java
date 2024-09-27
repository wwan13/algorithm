package boj10211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int t = Integer.parseInt(readLine());

        for (int c = 0; c < t; c++) {
            int n = Integer.parseInt(readLine());
            int[] data = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] dp = new int[n];

            int max = data[0];
            dp[0] = data[0];

            for (int i = 1; i < n; i++) {
                if (dp[i - 1] < 0) {
                    dp[i - 1] = 0;
                }
                dp[i] = dp[i - 1] + data[i];
                max = Math.max(max, dp[i]);
            }

            System.out.println(max);
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

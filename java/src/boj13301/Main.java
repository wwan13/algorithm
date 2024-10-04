package boj13301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        if (n == 1) {
            System.out.println(4);
            return;
        }

        if (n == 2) {
            System.out.println(6);
            return;
        }

        long[] dp = new long[n + 1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        long result = dp[n] * 3 + dp[n - 1] * 2 + dp[n - 2] * 2 + dp[n - 3];
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

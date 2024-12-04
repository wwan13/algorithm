package boj9657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        boolean[] dp = new boolean[n + 1];

        dp[1] = true;
        if (n >= 2) dp[2] = false;
        if (n >= 3) dp[3] = true;
        if (n >= 4) dp[4] = true;

        for (int i = 5; i <= n; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 3] || !dp[i - 4];
        }

        System.out.println(dp[n] ? "SK" : "CY");
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

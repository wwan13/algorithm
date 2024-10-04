package boj1535;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        int[] damage = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] happiness = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] dp = new int[101];

        for (int i = 0; i < n; i++) {
            for (int j = 100; j > damage[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - damage[i]] + happiness[i]);
            }
        }

        System.out.println(dp[100]);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

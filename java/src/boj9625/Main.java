package boj9625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        Pair[] dp = new Pair[n + 1];
        dp[0] = new Pair(1, 0);
        dp[1] = new Pair(0, 1);

        IntStream.range(2, n + 1).forEach(i -> {
            dp[i] = Pair.add(dp[i - 2], dp[i - 1]);
        });

        System.out.printf("%d %d", dp[n].a, dp[n].b);
    }

    static class Pair {
        final int a;
        final int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        static Pair add(Pair a, Pair b) {
            return new Pair(a.a + b.a, a.b + b.b);
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

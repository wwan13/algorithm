package boj2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] memory;
    static StringBuilder tmpSb;
    static StringBuilder resultSb;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        memory = new int[n];
        tmpSb = new StringBuilder();
        resultSb = new StringBuilder();

        dfs(0);

        System.out.print(resultSb);
    }

    private static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) resultSb.append(memory[i]);
            resultSb.append('\n');
            return;
        }

        if (depth == 0) {
            int[] first = {2, 3, 5, 7};
            for (int d : first) {
                memory[0] = d;
                dfs(1);
            }
            return;
        }

        tmpSb.setLength(0);
        for (int i = 0; i < depth; i++) tmpSb.append(memory[i]);

        for (int d = 1; d <= 9; d += 2) {
            tmpSb.append(d);
            int target = Integer.parseInt(tmpSb.toString());

            if (isPrime(target)) {
                memory[depth] = d;
                dfs(depth + 1);
            }

            tmpSb.setLength(depth);
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int d = 3; (long) d * d <= n; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }
}
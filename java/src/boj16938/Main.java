package boj16938;

import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int l;
    static int r;
    static int x;

    static int[] problems;

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nlrx = reader.readLine().split(" ");
        n = Integer.parseInt(nlrx[0]);
        l = Integer.parseInt(nlrx[1]);
        r = Integer.parseInt(nlrx[2]);
        x = Integer.parseInt(nlrx[3]);

        problems = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int k = 2; k <= n; k++) {
            dfs(0, 0, k, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int depth, int k, int sum, int min, int max) {
        if (sum > r) return;

        if (depth == k) {
            if (sum >= l && (max - min) >= x) {
                answer++;
            }
            return;
        }

        for (int i = start; i < n; i++) {
            int cur = problems[i];
            dfs(
                    i + 1,
                    depth + 1,
                    k,
                    sum + cur,
                    Math.min(min, cur),
                    Math.max(max, cur)
            );
        }
    }
}
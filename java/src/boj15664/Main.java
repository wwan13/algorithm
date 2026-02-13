package boj15664;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static int m;
    static int[] data;
    static int[] memory;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        data = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        memory = new int[m];

        dfs(0, 0);

        System.out.print(sb);
    }

    private static void dfs(int depth, int prev) {
        if (depth == m) {
            for (int i = 0; i < m; i++) sb.append(memory[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = prev; i < n; i++) {
            if (i > prev && data[i] == data[i - 1]) continue;

            memory[depth] = data[i];
            dfs(depth + 1, i + 1);
        }
    }
}
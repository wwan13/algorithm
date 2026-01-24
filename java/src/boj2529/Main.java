package boj2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[] arrows;
    static int[] memory;
    static boolean[] visited;

    static String maxStr = null;
    static String minStr = null;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        String[] parts = reader.readLine().split(" ");

        arrows = new char[n];
        for (int i = 0; i < n; i++) arrows[i] = parts[i].charAt(0);

        memory = new int[n + 1];
        visited = new boolean[10];

        dfs(0);

        System.out.println(maxStr);
        System.out.println(minStr);
    }

    private static void dfs(int depth) {
        if (depth == n + 1) {
            String s = toNumberString();
            if (minStr == null || s.compareTo(minStr) < 0) minStr = s;
            if (maxStr == null || s.compareTo(maxStr) > 0) maxStr = s;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;

            if (depth > 0) {
                int before = memory[depth - 1];
                char arrow = arrows[depth - 1];

                if (arrow == '<' && !(before < i)) continue;
                if (arrow == '>' && !(before > i)) continue;
            }

            visited[i] = true;
            memory[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    private static String toNumberString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + 1; i++) sb.append(memory[i]);
        return sb.toString();
    }
}
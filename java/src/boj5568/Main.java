package boj5568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static int n;
    static int k;
    static String[] cards;
    static boolean[] visited;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine().trim());
        k = Integer.parseInt(reader.readLine().trim());

        cards = new String[n];
        for (int i = 0; i < n; i++) {
            cards[i] = reader.readLine().trim();
        }

        visited = new boolean[n];
        dfs(0, new StringBuilder());

        System.out.println(set.size());
    }

    static void dfs(int depth, StringBuilder sb) {
        if (depth == k) {
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            visited[i] = true;

            int lenBefore = sb.length();
            sb.append(cards[i]);
            dfs(depth + 1, sb);
            sb.setLength(lenBefore);

            visited[i] = false;
        }
    }
}
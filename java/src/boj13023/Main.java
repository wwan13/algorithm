package boj13023;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] g;
    static boolean[] visited;
    static boolean result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        result = false;
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 0);
            visited[i] = false;
            if (result) break;
        }

        System.out.println(result ? 1 : 0);
    }

    static void dfs(int cur, int depth) {
        if (result) return;
        if (depth == 4) {
            result = true;
            return;
        }

        for (int nxt : g[cur]) {
            if (visited[nxt]) continue;
            visited[nxt] = true;
            dfs(nxt, depth + 1);
            visited[nxt] = false;
            if (result) return;
        }
    }
}
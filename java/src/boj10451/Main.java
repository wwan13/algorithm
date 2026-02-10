package boj10451;

import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            p = new int[n + 1];
            visited = new boolean[n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) p[i] = Integer.parseInt(st.nextToken());

            int cycles = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    cycles++;
                    dfs(i);
                }
            }
            sb.append(cycles).append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int start) {
        int cur = start;
        while (!visited[cur]) {
            visited[cur] = true;
            cur = p[cur];
        }
    }
}

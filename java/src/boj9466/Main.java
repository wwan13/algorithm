package boj9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] data;
    private static boolean[] visited;
    private static Set<Integer> finished;
    private static int count;

    public static void main(String[] args) {
        int t = Integer.parseInt(readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(readLine());

            data = new int[n + 1];
            String[] line = readLine().split(" ");
            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(line[i]);
                data[i + 1] = value;
            }

            visited = new boolean[n + 1];
            finished = new HashSet<>();
            count = 0;

            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - count);
        }
    }

    private static void dfs(int current) {
        visited[current] = true;

        if (!visited[data[current]]) {
            dfs(data[current]);
        } else if (!finished.contains(data[current])) {
            int value = data[current];
            count += 1;
            while (value != current) {
                count += 1;
                value = data[value];
            }
        }

        finished.add(current);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

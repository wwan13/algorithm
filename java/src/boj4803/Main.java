package boj4803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int[] parents;
    private static boolean[] hasCycle;

    public static void main(String[] args) {
        int t = 1;

        while (true) {
            String line = readLine();
            if (line.equals("0 0")) {
                break;
            }

            String[] nm = line.split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            parents = new int[n + 1];
            hasCycle = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < m; i++) {
                String[] elements = readLine().split(" ");
                int a = Integer.parseInt(elements[0]);
                int b = Integer.parseInt(elements[1]);
                if (find(a) == find(b)) {
                    hasCycle[find(a)] = true;
                } else {
                    union(a, b);
                }
            }

            Set<Integer> roots = new HashSet<>();
            int treeCount = 0;
            for (int i = 1; i <= n; i++) {
                int root = find(i);
                if (!roots.contains(root)) {
                    roots.add(root);
                    if (!hasCycle[root]) {
                        treeCount++;
                    }
                }
            }

            if (treeCount == 0) {
                System.out.println("Case " + t + ": No trees.");
            } else if (treeCount == 1) {
                System.out.println("Case " + t + ": There is one tree.");
            } else {
                System.out.println("Case " + t + ": A forest of " + treeCount + " trees.");
            }

            t++;
        }
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parents[rootY] = rootX;
        }
    }

    private static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]); // 경로 압축
        }
        return parents[x];
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int answer = 0;

    static boolean[] colUsed;      // 열
    static boolean[] diag1Used;    // 오른쪽 아래 대각선
    static boolean[] diag2Used;    // 오른쪽 위 대각선

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        colUsed = new boolean[n];
        diag1Used = new boolean[2 * n - 1];
        diag2Used = new boolean[2 * n - 1];

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + (n - 1);

            if (colUsed[col] || diag1Used[d1] || diag2Used[d2]) continue;

            colUsed[col] = true;
            diag1Used[d1] = true;
            diag2Used[d2] = true;

            dfs(row + 1);

            colUsed[col] = false;
            diag1Used[d1] = false;
            diag2Used[d2] = false;
        }
    }
}
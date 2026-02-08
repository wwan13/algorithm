package boj2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] map = new int[9][9];

    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] colUsed = new boolean[9][10];
    static boolean[][] boxUsed = new boolean[9][10];

    static List<int[]> blanks = new ArrayList<>();
    static boolean solved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String row = reader.readLine().trim();
            for (int j = 0; j < 9; j++) {
                int v = row.charAt(j) - '0';
                map[i][j] = v;

                if (v == 0) {
                    blanks.add(new int[]{i, j});
                } else {
                    rowUsed[i][v] = true;
                    colUsed[j][v] = true;
                    boxUsed[boxIndex(i, j)][v] = true;
                }
            }
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) sb.append(map[i][j]);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int idx) {
        if (solved) return;
        if (idx == blanks.size()) {
            solved = true;
            return;
        }

        int r = blanks.get(idx)[0];
        int c = blanks.get(idx)[1];
        int b = boxIndex(r, c);

        for (int num = 1; num <= 9; num++) {
            if (rowUsed[r][num] || colUsed[c][num] || boxUsed[b][num]) continue;

            map[r][c] = num;
            rowUsed[r][num] = true;
            colUsed[c][num] = true;
            boxUsed[b][num] = true;

            dfs(idx + 1);

            if (solved) return;

            map[r][c] = 0;
            rowUsed[r][num] = false;
            colUsed[c][num] = false;
            boxUsed[b][num] = false;
        }
    }

    static int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}
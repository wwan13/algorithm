package boj2580;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    static List<int[]> blanks = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if (map[i][j] == 0) blanks.add(new int[]{i, j});
            }
        }

        dfs(0);
    }

    static void dfs(int idx) {
        if (idx == blanks.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                    if (j < 8) sb.append(' ');
                }
                sb.append('\n');
            }
            System.out.print(sb);
            return;
        }

        int r = blanks.get(idx)[0];
        int c = blanks.get(idx)[1];

        for (int v = 1; v <= 9; v++) {
            if (isValid(r, c, v)) {
                map[r][c] = v;
                dfs(idx + 1);
                map[r][c] = 0;
            }
        }
    }

    static boolean isValid(int r, int c, int v) {
        // 가로
        for (int j = 0; j < 9; j++) {
            if (map[r][j] == v) return false;
        }
        // 세로
        for (int i = 0; i < 9; i++) {
            if (map[i][c] == v) return false;
        }
        // 박스
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (map[i][j] == v) return false;
            }
        }
        return true;
    }
}
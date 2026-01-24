package boj1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static char[][] map;
    static boolean[][] visited;
    static int[][] memory;
    static int count = 0;

    static HashSet<String> seen = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        visited = new boolean[5][5];
        memory = new int[7][2];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                visited[i][j] = true;
                memory[0][0] = i;
                memory[0][1] = j;

                int sCount = (map[i][j] == 'S') ? 1 : 0;
                dfs(1, sCount);

                visited[i][j] = false;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int depth, int sCount) {
        // 가지치기
        if (sCount + (7 - depth) < 4) return;

        if (depth == 7) {
            // 중복 제거용 key 생성
            int[] keyArr = new int[7];
            for (int i = 0; i < 7; i++) {
                keyArr[i] = memory[i][0] * 5 + memory[i][1];
            }
            Arrays.sort(keyArr);
            String key = Arrays.toString(keyArr);

            if (seen.add(key)) count++;
            return;
        }

        boolean[][] candidate = new boolean[5][5];

        // 현재 선택된 모든 칸의 이웃을 후보로
        for (int i = 0; i < depth; i++) {
            int x = memory[i][0];
            int y = memory[i][1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if (visited[nx][ny]) continue;

                candidate[nx][ny] = true;
            }
        }

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                if (!candidate[x][y]) continue;

                visited[x][y] = true;
                memory[depth][0] = x;
                memory[depth][1] = y;

                dfs(depth + 1, sCount + (map[x][y] == 'S' ? 1 : 0));

                visited[x][y] = false;
            }
        }
    }
}
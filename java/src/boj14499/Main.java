package boj14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] DX = {0, 0, 0, -1, 1};
    private static final int[] DY = {0, 1, -1, 0, 0};

    private static int[] dice = new int[7];

    public static void main(String[] args) {
        String[] line = readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);
        int y = Integer.parseInt(line[3]);
        int k = Integer.parseInt(line[4]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] commands = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int command : commands) {
            int nx = x + DX[command];
            int ny = y + DY[command];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            int[] newDice = dice.clone();
            switch (command) {
                case 1: // 동쪽
                    dice[1] = newDice[4];
                    dice[3] = newDice[1];
                    dice[4] = newDice[6];
                    dice[6] = newDice[3];
                    break;
                case 2: // 서쪽
                    dice[1] = newDice[3];
                    dice[3] = newDice[6];
                    dice[4] = newDice[1];
                    dice[6] = newDice[4];
                    break;
                case 3: // 북쪽
                    dice[1] = newDice[5];
                    dice[2] = newDice[1];
                    dice[5] = newDice[6];
                    dice[6] = newDice[2];
                    break;
                case 4: // 남쪽
                    dice[1] = newDice[2];
                    dice[2] = newDice[6];
                    dice[5] = newDice[1];
                    dice[6] = newDice[5];
                    break;
            }

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6];
            } else {
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }

            System.out.println(dice[1]);

            x = nx;
            y = ny;
        }
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

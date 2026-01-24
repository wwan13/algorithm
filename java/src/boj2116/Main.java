package boj2116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[][] dices = new int[n][6];

        for (int i = 0; i < n; i++) {
            dices[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] top = new int[]{5, 3, 4, 1, 2, 0};

        int[][] sides = new int[][]{
                {1, 2, 3, 4}, // 0
                {0, 2, 4, 5}, // 1
                {0, 1, 3, 5}, // 2
                {0, 2, 4, 5}, // 3
                {0, 1, 3, 5}, // 4
                {1, 2, 3, 4}, // 5
        };

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 6; i++) {
            int currentBottom = i;
            int currentTop = top[currentBottom];

            int maxSum = max(sides[currentBottom], dices[0]);
            int topValue = dices[0][currentTop];

            for (int j = 1; j < n; j++) {
                currentBottom = indexAt(dices[j], topValue);
                currentTop = top[currentBottom];

                maxSum += max(sides[currentBottom], dices[j]);
                topValue = dices[j][currentTop];
            }

            max = Math.max(max, maxSum);
        }

        System.out.println(max);
    }

    private static int indexAt(int[] dice, int value) {
        for (int i = 0; i < 6; i++) {
            if (dice[i] == value) return i;
        }
        return -1;
    }

    private static int max(int[] sides, int[] dice) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            max = Math.max(max, dice[sides[i]]);
        }
        return max;
    }
}
package boj5549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = reader.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int k = Integer.parseInt(reader.readLine());

        int[][] jSum = new int[n + 1][m + 1];
        int[][] oSum = new int[n + 1][m + 1];
        int[][] iSum = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            char[] row = reader.readLine().toCharArray();
            for (int j = 1; j < m + 1; j++) {
                char c = row[j - 1];

                prefixSum(jSum, i, j, c == 'J' ? 1 : 0);
                prefixSum(oSum, i, j, c == 'O' ? 1 : 0);
                prefixSum(iSum, i, j, c == 'I' ? 1 : 0);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            String[] row = reader.readLine().split(" ");
            int x1 = Integer.parseInt(row[0]);
            int y1 = Integer.parseInt(row[1]);
            int x2 = Integer.parseInt(row[2]);
            int y2 = Integer.parseInt(row[3]);

            sb.append(calculate(jSum, x1, y1, x2, y2)).append(' ')
                    .append(calculate(oSum, x1, y1, x2, y2)).append(' ')
                    .append(calculate(iSum, x1, y1, x2, y2)).append('\n');
        }

        System.out.println(sb);
    }

    private static void prefixSum(int[][] prefixSum, int i, int j, int add) {
        prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + add;
    }

    private static int calculate(int[][] prefixSum, int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    }
}

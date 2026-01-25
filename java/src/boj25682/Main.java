package boj25682;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nmk = reader.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]);
        int m = Integer.parseInt(nmk[1]);
        int k = Integer.parseInt(nmk[2]);

        char[][] board = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String row = reader.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] = row.charAt(j - 1);
            }
        }

        int[][] prefixSumWhite = new int[n + 1][m + 1];
        int[][] prefixSumBlack = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                int mw = (board[i][j] == expectedW) ? 0 : 1;

                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';
                int mb = (board[i][j] == expectedB) ? 0 : 1;

                prefixSumWhite[i][j] =
                        prefixSumWhite[i - 1][j] + prefixSumWhite[i][j - 1]
                                - prefixSumWhite[i - 1][j - 1] + mw;

                prefixSumBlack[i][j] =
                        prefixSumBlack[i - 1][j] + prefixSumBlack[i][j - 1]
                                - prefixSumBlack[i - 1][j - 1] + mb;
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n - k + 1; i++) {
            for (int j = 1; j <= m - k + 1; j++) {
                int x2 = i + k - 1;
                int y2 = j + k - 1;

                int w = prefixSumWhite[x2][y2] - prefixSumWhite[i - 1][y2] - prefixSumWhite[x2][j - 1] + prefixSumWhite[i - 1][j - 1];

                int b = prefixSumBlack[x2][y2] - prefixSumBlack[i - 1][y2] - prefixSumBlack[x2][j - 1] + prefixSumBlack[i - 1][j - 1];

                answer = Math.min(answer, Math.min(w, b));
            }
        }

        System.out.println(answer);
    }
}
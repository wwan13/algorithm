package boj2167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nmLine = reader.readLine().split(" ");
        int n = Integer.parseInt(nmLine[0]);
        int m = Integer.parseInt(nmLine[1]);

        long[][] prefixSum = new long[n][m];

        for (int i = 0; i < n; i++) {
            long[] line = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            for (int j = 0; j < m; j++) {
                long sum = line[j];

                if (i > 0) {
                    sum += prefixSum[i - 1][j];
                }
                if (j > 0) {
                    sum += prefixSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sum -= prefixSum[i - 1][j - 1];
                }

                prefixSum[i][j] = sum;
            }
        }

        int k = Integer.parseInt(reader.readLine());

        for (int q = 0; q < k; q++) {
            String[] query = reader.readLine().split(" ");
            int i = Integer.parseInt(query[0]) - 1;
            int j = Integer.parseInt(query[1]) - 1;
            int x = Integer.parseInt(query[2]) - 1;
            int y = Integer.parseInt(query[3]) - 1;

            long result = prefixSum[x][y];

            if (i > 0) {
                result -= prefixSum[i - 1][y];
            }
            if (j > 0) {
                result -= prefixSum[x][j - 1];
            }
            if (i > 0 && j > 0) {
                result += prefixSum[i - 1][j - 1];
            }

            System.out.println(result);
        }
    }
}
package boj1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nk = readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[][] data = new int[n][k];
        for (int i = 0; i < n; i++) {
            String[] line = readLine().split("");
            for (int j = 0; j < k; j++) {
                data[i][j] = Integer.parseInt(line[j]);
            }
        }

        int min = Math.min(n, k);
        for (int size = min; size > 1; size--) {
            for (int i = 0; i < n - size + 1; i++) {
                for (int j = 0; j < k - size + 1; j++) {
                    if ((data[i][j] == data[i + size - 1][j]) && (data[i][j] == data[i][j + size - 1])
                            && (data[i][j] == data[i + size - 1][j + size - 1])) {
                        System.out.println(size * size);
                        return;
                    }
                }
            }
        }
        System.out.println(1);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

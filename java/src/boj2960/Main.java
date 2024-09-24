package boj2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nk = readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] data = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            data[i] = i;
        }

        int count = 0;
        while (true) {
            int p = -1;
            for (int i = 2; i < n + 1; i++) {
                if (data[i] != 0) {
                    p = i;
                    break;
                }
            }

            int i = 1;
            while (true) {
                if (i * p > n) {
                    break;
                }

                if (data[i * p] != 0) {
                    data[i * p] = 0;
                    count++;
                }

                if (count == k) {
                    System.out.println(i * p);
                    return;
                }

                i++;
            }
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

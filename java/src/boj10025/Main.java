package boj10025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int MAX_RANGE = 1000000;

    public static void main(String[] args) {
        String[] nk = readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] data = new int[MAX_RANGE + 1];
        for (int i = 0; i < n; i++) {
            String[] gx = readLine().split(" ");
            int g = Integer.parseInt(gx[0]);
            int x = Integer.parseInt(gx[1]);

            data[x] = g;
        }

        long window = 0;
        for (int i = 0; i < k + 1 && i < data.length; i++) {
            window += data[i];
        }

        long result = 0;

        for (int i = 0; i < MAX_RANGE + 1; i++) {
            int left = i - k - 1;
            int right = i + k + 1;

            if (left >= 0) {
                window -= data[left];
            }

            if (right < MAX_RANGE + 1) {
                window += data[right];
            }

            result = Math.max(result, window);
        }

        System.out.println(result);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

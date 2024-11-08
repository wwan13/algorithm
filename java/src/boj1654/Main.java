package boj1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] kn = readLine().split(" ");
        int k = Integer.parseInt(kn[0]);
        long n = Long.parseLong(kn[1]);

        long[] lines = new long[k];
        for (int i = 0; i < k; i++) {
            lines[i] = Long.parseLong(readLine());
        }

        long left = 1;
        long right = Arrays.stream(lines).max().getAsLong();
        long result = Integer.MIN_VALUE;
        while (left <= right) {
            long mid = (left + right) / 2;
            long divide = divide(lines, mid);

            if (divide < n) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static long divide(long[] lines, long divideLength) {
        long count = 0;
        for (long line : lines) {
            count += (line / divideLength);
        }
        return count;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

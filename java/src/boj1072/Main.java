package boj1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] row = reader.readLine().split(" ");
        long x = Long.parseLong(row[0]);
        long y = Long.parseLong(row[1]);

        int init = calculate(x, y);

        if (init >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000L;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            int newRate = calculate(x + mid, y + mid);

            if (newRate > init) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static int calculate(long x, long y) {
        return (int) ((y * 100) / x);
    }
}
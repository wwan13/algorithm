package boj2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.LongStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        long[] data = LongStream.range(0, n)
                .map(it -> Long.parseLong(readLine()))
                .sorted()
                .toArray();

        long min = Long.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (left < right && data[right] - data[left] >= m) {
                left += 1;
            }

            if (left > 0) {
                min = Math.min(min, data[right] - data[left - 1]);
            }
        }

        System.out.println(min);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

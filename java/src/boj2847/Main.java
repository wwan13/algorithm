package boj2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int[] data = IntStream.range(0, n)
                .map(it -> Integer.parseInt(readLine()))
                .toArray();

        int prev = data[n - 1];
        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            int target = data[i];
            while (target >= prev) {
                target -= 1;
                count += 1;
            }
            prev = target;
        }

        System.out.println(count);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

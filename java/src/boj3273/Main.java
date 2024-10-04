package boj3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int[] data = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int x = Integer.parseInt(readLine());

        int count = 0;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = data[start] + data[end];
            if (sum == x) {
                count += 1;
            }

            if (sum <= x) {
                start += 1;
            }

            if (sum > x) {
                end -= 1;
            }
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

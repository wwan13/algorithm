package boj1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        long[] data = Arrays.stream(readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        int count = 0;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                if (left == i) {
                    left += 1;
                    continue;
                }
                if (right == i) {
                    right -= 1;
                    continue;
                }

                long sum = data[left] + data[right];

                if (sum == data[i]) {
                    count += 1;
                    break;
                } else if (sum < data[i]) {
                    left += 1;
                } else {
                    right -= 1;
                }
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

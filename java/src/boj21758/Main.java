package boj21758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] honey = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long[] prefix = new long[n];
        prefix[0] = honey[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + honey[i];
        }
        long total = prefix[n - 1];

        long answer = 0;

        // 벌통이 오른쪽
        for (int i = 1; i <= n - 2; i++) {
            long leftBee = total - honey[0] - honey[i];
            long midBee = total - prefix[i];
            answer = Math.max(answer, leftBee + midBee);
        }

        // 벌통이 왼쪽
        for (int i = 1; i <= n - 2; i++) {
            long rightBee = total - honey[n - 1] - honey[i];
            long midBee = prefix[i - 1];
            answer = Math.max(answer, rightBee + midBee);
        }

        // 벌통이 가운데
        for (int i = 1; i <= n - 2; i++) {
            long value = total - honey[0] - honey[n - 1] + honey[i];
            answer = Math.max(answer, value);
        }

        System.out.println(answer);
    }
}
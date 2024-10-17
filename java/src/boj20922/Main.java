package boj20922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nk = readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] data = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] count = new int[100001];
        int left = 0;
        int right = 0;
        int answer = Integer.MIN_VALUE;

        while (right < n) {
            while (right < n && count[data[right]] + 1 <= k) {
                count[data[right]] += 1;
                right += 1;
            }

            answer = Math.max(answer, right - left);
            count[data[left]] -= 1;
            left += 1;
        }

        System.out.println(answer);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

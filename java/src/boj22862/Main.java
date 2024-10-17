package boj22862;

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

        int left = 0;
        int oddCount = 0;
        int answer = Integer.MIN_VALUE;

        for (int right = 0; right < n; right++) {
            if (data[right] % 2 == 1) {
                oddCount += 1;
            }

            while (oddCount > k) {
                if (data[left] % 2 == 1) {
                    oddCount -= 1;
                }
                left += 1;
            }

            answer = Math.max(answer, right - left + 1 - oddCount);
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

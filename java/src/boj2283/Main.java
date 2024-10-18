package boj2283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nk = readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        long[] data = new long[1000001];
        for (int i = 0; i < n; i++) {
            String[] line = readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            data[start] += 1;
            data[end] -= 1;
        }

        for (int i = 1; i < 1000001; i++) {
            data[i] += data[i - 1];
        }

        int left = 0;
        int right = 0;
        long sum = 0;
        while (right < 1000001) {
            if (sum < k) {
                sum += data[right];
                right += 1;
            } else if (sum > k) {
                sum -= data[left];
                left += 1;
            } else if (sum == k) {
                System.out.println(left + " " + right);
                return;
            }
        }

        System.out.println("0 0");
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

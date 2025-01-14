package boj16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());

        int[] snacks = new int[m];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = Arrays.stream(snacks).max().orElse(0);
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDistribute(snacks, n, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canDistribute(int[] snacks, int n, int length) {
        int count = 0;
        for (int snack : snacks) {
            count += snack / length;
        }
        return count >= n;
    }
}

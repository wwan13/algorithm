package boj30802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int[] sizes = Arrays.stream(readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String tp[] = readLine().split(" ");
        int t = Integer.parseInt(tp[0]);
        int p = Integer.parseInt(tp[1]);

        int clothBundleCount = 0;
        for (int size : sizes) {
            clothBundleCount += (size + t - 1) / t;
        }

        int penBundleCount = n / p;
        int penEachCount = n % p;

        System.out.println(clothBundleCount);
        System.out.printf("%d %d", penBundleCount, penEachCount);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

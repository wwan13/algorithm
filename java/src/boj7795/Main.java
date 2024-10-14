package boj7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int t = Integer.parseInt(readLine());

        while (t-- > 0) {
            final String[] nm = readLine().split(" ");
            final int n = Integer.parseInt(nm[0]);
            final int m = Integer.parseInt(nm[1]);

            final int[] a = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();


            final int[] b = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            int count = 0;
            for (int value : a) {
                count += binarySearch(b, value);
            }

            System.out.println(count);
        }
    }

    private static int binarySearch(int[] b, int value) {
        int left = 0;
        int right = b.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (b[middle] < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

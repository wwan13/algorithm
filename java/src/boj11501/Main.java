package boj11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int t = Integer.parseInt(readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(readLine());
            int[] prices = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            long profit = 0;
            int maxPrice = Integer.MIN_VALUE;

            for (int i = n - 1; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    maxPrice = prices[i];
                } else {
                    profit += maxPrice - prices[i];
                }
            }

            System.out.println(profit);
        }
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package boj1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Brand {
        final int bundle;
        final int each;

        Brand(int bundle, int each) {
            this.bundle = bundle;
            this.each = each;
        }
    }

    public static void main(String[] args) {
        String[] mn = readLine().split(" ");
        int n = Integer.parseInt(mn[0]);
        int m = Integer.parseInt(mn[1]);

        int minBundle = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            String[] line = readLine().split(" ");
            int bundle = Integer.parseInt(line[0]);
            minBundle = Math.min(minBundle, bundle);

            int each = Integer.parseInt(line[1]);
            minEach = Math.min(minEach, each);
        }

        if (minEach * 6 <= minBundle) {
            System.out.println(minEach * n);
            return;
        }

        int count = 0;
        int money = 0;
        while (true) {
            if (n - count >= 6) {
                money += minBundle;
                count += 6;
            } else {
                int eachMoney = 0;
                for (int j = 0; j < n - count; j++) {
                    eachMoney += minEach;
                }

                money += Math.min(eachMoney, minBundle);
                break;
            }
        }

        System.out.println(money);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

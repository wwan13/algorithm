package boj2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] line = readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int d = Integer.parseInt(line[1]);
        int k = Integer.parseInt(line[2]);
        int c = Integer.parseInt(line[3]);

        int[] sushi = IntStream.range(0, n)
                .map(it -> Integer.parseInt(readLine()))
                .toArray();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(sushi[i]);
        }

        int[] sushiCount = new int[d + 1];
        int currentDishes = 0;

        for (int i = 0; i < k; i++) {
            if (sushiCount[sushi[i]] == 0) {
                currentDishes++;
            }
            sushiCount[sushi[i]]++;
        }

        int maxDishes = currentDishes;
        if (sushiCount[c] == 0) {
            maxDishes++;
        }

        for (int i = 1; i < n; i++) {
            int outgoingSushi = sushi[i - 1];
            sushiCount[outgoingSushi]--;
            if (sushiCount[outgoingSushi] == 0) {
                currentDishes--;
            }

            int incomingSushi = sushi[(i + k - 1) % n];
            if (sushiCount[incomingSushi] == 0) {
                currentDishes++;
            }
            sushiCount[incomingSushi]++;

            int totalDishes = currentDishes;
            if (sushiCount[c] == 0) {
                totalDishes++;
            }

            maxDishes = Math.max(maxDishes, totalDishes);
        }

        System.out.println(maxDishes);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

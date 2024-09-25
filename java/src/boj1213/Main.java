package boj1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String data = readLine();

        int[] alpha = new int[26];
        for (int i = 0; i < data.length(); i++) {
            alpha[data.charAt(i) - 'A'] += 1;
        }

        int center = -1;
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                center = i;
                odd += 1;
            }
        }

        if (odd > 1 || (data.length() % 2 == 0 && odd == 1)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append((char) ('A' + i));
            }
        }

        String forward = sb.toString();
        String reverse = sb.reverse().toString();
        if (odd == 1) {
            System.out.printf("%s%c%s", forward, 'A' + center, reverse);
            return;
        }

        System.out.printf("%s%s", forward, reverse);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

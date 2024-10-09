package boj15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int R = 31;
    private static final int M = 1234567891;

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        char[] data = readLine().toCharArray();

        long result = 0L;
        long power = 1L;
        for (int i = 0; i < n; i++) {
            result += ((data[i] - 'a' + 1) * power) % M;
            power = (power * R) % M;
        }

        System.out.println(result % M);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

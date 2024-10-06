package boj9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String line = readLine();
        String bomb = readLine();
        int bombSize = bomb.length();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            result.append(line.charAt(i));

            if (result.length() >= bombSize) {
                if (result.substring(result.length() - bombSize).equals(bomb)) {
                    result.delete(result.length() - bombSize, result.length());
                }
            }
        }

        if (result.length() == 0) {
            System.out.println("FRULA");
            return;
        }
        System.out.println(result);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

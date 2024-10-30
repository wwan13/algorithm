package boj5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        List<Long> data = new ArrayList<>();

        String[] firstLine = readLine().split(" ");
        long n = Long.parseLong(firstLine[0]);
        for (int i = 1; i < firstLine.length; i++) {
            data.add(Long.parseLong(reverse(firstLine[i])));
        }

        while (data.size() < n) {
            String line = readLine();

            for (String value : line.split(" ")) {
                data.add(Long.parseLong(reverse(value)));
            }
        }

        StringBuilder sb = new StringBuilder();
        data.stream()
                .sorted()
                .forEach(it -> sb.append(it).append("\n"));

        System.out.println(sb);
    }

    private static String reverse(String value) {
        char[] chars = value.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = value.length() - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return new String(sb);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

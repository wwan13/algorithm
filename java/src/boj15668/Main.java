package boj15668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, n)
                .map(it -> Integer.parseInt(readLine()))
                .sorted()
                .forEach(it -> sb.append(it).append("\n"));

        System.out.println(sb);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

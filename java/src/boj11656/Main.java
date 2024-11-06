package boj11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String data = readLine();

        IntStream.range(0, data.length())
                .mapToObj(data::substring)
                .sorted()
                .forEach(System.out::println);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

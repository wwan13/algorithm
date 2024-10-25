package boj1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Serial {
        final String number;

        Serial(String number) {
            this.number = number;
        }

        public String getNumber() {
            return number;
        }

        int length() {
            return number.length();
        }

        int calculateNumbers() {
            return Arrays.stream(number.split(""))
                    .filter(it -> it.compareTo("1") >= 0 && it.compareTo("9") <= 0)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        IntStream.range(0, n)
                .mapToObj(it -> new Serial(readLine()))
                .sorted(
                        Comparator.comparing(Serial::length)
                                .thenComparing(Serial::calculateNumbers)
                                .thenComparing(Serial::getNumber)
                )
                .forEach(it -> System.out.println(it.number));
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

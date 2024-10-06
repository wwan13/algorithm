package boj1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int[] data = IntStream.range(0, n)
                .map(it -> Integer.parseInt(readLine()))
                .toArray();

        int[] positive = Arrays.stream(data)
                .filter(it -> it > 0)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int[] negative = Arrays.stream(data)
                .filter(it -> it <= 0)
                .sorted()
                .toArray();

        int result = 0;
        for (int i = 0; i < positive.length; i++) {
            int target = positive[i];

            if (i == positive.length - 1) {
                result += target;
                break;
            }

            int next = positive[i + 1];

            if (target >= 2 && next >= 2) {
                result += target * next;
                i += 1;
                continue;
            }

            result += target;
        }

        for (int i = 0; i < negative.length; i++) {
            int target = negative[i];

            if (i == negative.length - 1) {
                result += target;
                break;
            }

            int next = negative[i + 1];

            if (target <= 0 && next <= 2) {
                result += target * next;
                i += 1;
                continue;
            }

            result += target;
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

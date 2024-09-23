package boj6986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        final String[] nk = readLine().split(" ");
        final int n = Integer.parseInt(nk[0]);
        final int k = Integer.parseInt(nk[1]);

        final List<Double> scores = new ArrayList<>();
        IntStream.range(0, n).forEach(it -> {
            Double score = Double.parseDouble(readLine());
            scores.add(score);
        });
        scores.sort(Comparator.comparing(it -> it));

        double trimmedAverage = 0;
        for (int i = k; i < n - k; i++) {
            trimmedAverage += scores.get(i);
        }
        trimmedAverage /= (n - (k * 2));
        System.out.printf("%.2f\n", trimmedAverage);

        double calibratedAverage = 0;
        for (int i = k; i < n - k; i++) {
            calibratedAverage += scores.get(i);
        }
        calibratedAverage += scores.get(k) * k;
        calibratedAverage += scores.get(n - k - 1) * k;
        calibratedAverage /= n;
        System.out.printf("%.2f\n", calibratedAverage);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

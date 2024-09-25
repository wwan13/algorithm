package boj18110;

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
        int n = Integer.parseInt(readLine());

        List<Integer> data = new ArrayList<>();
        IntStream.range(0, n).forEach(it ->
                data.add(Integer.parseInt(readLine()))
        );

        int removeCount = (int) Math.round(n * 0.15);

        int startIndex = removeCount;
        int endIndex = n - removeCount;
        int sum = 0;
        data.sort(Comparator.comparing(it -> it));
        for (int i = startIndex; i < endIndex; i++) {
            sum += data.get(i);
        }

        int average = Math.round((float) sum / (n - removeCount * 2));
        System.out.println(average);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package boj1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nl = readLine().split(" ");
        int n = Integer.parseInt(nl[0]);
        int l = Integer.parseInt(nl[1]);
        int[] points = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int count = 1;
        int startPoint = points[0];
        for (int i = 1; i < n; i++) {
            if (points[i] - startPoint >= l) {
                startPoint = points[i];
                count++;
            }
        }

        System.out.println(count);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package boj1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        int[][] data = new int[n][n];
        for (int i = 0; i < n; i++) {
            data[i] = Arrays.stream(readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.println(separate(data, n, 0, 0));
    }

    private static String separate(int[][] data, int size, int firstIndexX, int firstIndexY) {
        int firstData = data[firstIndexX][firstIndexY];
        boolean isAllSame = true;
        for (int i = firstIndexX; i < firstIndexX + size; i++) {
            for (int j = firstIndexY; j < firstIndexY + size; j++) {
                if (data[i][j] != firstData) {
                    isAllSame = false;
                    break;
                }
            }
            if (!isAllSame) {
                break;
            }
        }

        if (isAllSame) {
            return String.format("%d", firstData);
        }

        String s1 = separate(data, size / 2, firstIndexX, firstIndexY);
        String s2 = separate(data, size / 2, firstIndexX, firstIndexY + (size / 2));
        String s3 = separate(data, size / 2, firstIndexX + (size / 2), firstIndexY);
        String s4 = separate(data, size / 2, firstIndexX + (size / 2), firstIndexY + (size / 2));

        return String.format("(%s%s%s%s)", s1, s2, s3, s4);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

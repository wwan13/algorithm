package boj20366;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int[] data = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = 0;
                int right = n - 1;

                while (left < right) {
                    if (left != i && left != j && right != i && right != j) {
                        int snowman1 = data[i] + data[j];
                        int snowman2 = data[left] + data[right];
                        int difference = Math.abs(snowman1 - snowman2);

                        answer = Math.min(answer, difference);

                        if (snowman1 < snowman2) {
                            right--;
                        } else {
                            left++;
                        }
                    } else if (left == i || left == j) {
                        left += 1;
                    } else if (right == i || right == j) {
                        right -= 1;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

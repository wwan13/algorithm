package boj13144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int[] data = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> set = new HashSet<>();
        int right = 0;
        long answer = 0;

        for (int left = 0; left < n; left++) {
            while (right < n && !set.contains(data[right])) {
                set.add(data[right]);
                right += 1;
            }

            answer += right - left;

            set.remove(data[left]);
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

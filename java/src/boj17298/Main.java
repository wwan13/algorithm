package boj17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int[] data = new int[n];
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(readLine());

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        Arrays.fill(numbers, -1);

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && data[stack.peek()] < data[i]) {
                numbers[stack.pop()] = data[i];
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append(num).append(" ");
        }

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

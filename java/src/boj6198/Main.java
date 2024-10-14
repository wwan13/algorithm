package boj6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        long[] buildings = IntStream.range(0, n)
                .mapToLong(it -> Long.parseLong(readLine()))
                .toArray();

        Stack<Integer> stack = new Stack<>();

        long count = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]) {
                stack.pop();
            }

            count += stack.size();
            stack.push(i);
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

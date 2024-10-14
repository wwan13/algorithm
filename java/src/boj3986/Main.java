package boj3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        final int n = Integer.parseInt(readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            char[] data = readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char c : data) {
                checkIf('A', c, stack);
                checkIf('B', c, stack);
            }

            if (stack.isEmpty()) {
                count += 1;
            }
        }

        System.out.println(count);
    }

    private static void checkIf(char target, char now, Stack<Character> stack) {
        if (now == target) {
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
            } else {
                stack.push(now);
            }
        }
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

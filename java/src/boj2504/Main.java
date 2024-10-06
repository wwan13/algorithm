package boj2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        char[] data = readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int count = 1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '(') {
                stack.push(data[i]);
                count *= 2;
                continue;
            }

            if (data[i] == '[') {
                stack.push(data[i]);
                count *= 3;
                continue;
            }

            if (data[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }
                if (data[i - 1] == '(') {
                    result += count;
                }
                stack.pop();
                count /= 2;
                continue;
            }

            if (data[i] == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }
                if (data[i - 1] == '[') {
                    result += count;
                }
                stack.pop();
                count /= 3;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
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

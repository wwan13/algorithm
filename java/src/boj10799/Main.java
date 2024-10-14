package boj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        char[] data = readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < data.length; i++) {
            char c = data[i];
            if (c == ')') {
                if (!stack.isEmpty() && data[i - 1] == '(') {
                    stack.pop();
                    count += stack.size();
                } else {
                    stack.pop();
                    count += 1;
                }
            }

            if (c == '(') {
                stack.push(c);
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

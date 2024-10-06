package boj1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        char[] data = readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char target : data) {
            if (Character.isLetter(target)) {
                result.append(target);
                continue;
            }

            if (target == '(') {
                stack.push(target);
            }

            if (target == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
                continue;
            }

            if (target == '*' || target == '/' || target == '+' || target == '-') {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(target)) {
                    result.append(stack.pop());
                }
                stack.push(target);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result);
    }

    private static int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }

        if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

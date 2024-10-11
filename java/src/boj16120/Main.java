package boj16120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        char[] line = readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : line) {
            stack.push(c);

            if (stack.get(stack.size() - 4) == 'P' &&
                    stack.get(stack.size() - 3) == 'P' &&
                    stack.get(stack.size() - 2) == 'A' &&
                    stack.get(stack.size() - 1) == 'P') {

                stack.pop(); // P
                stack.pop(); // A
                stack.pop(); // P
            }
        }

        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
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

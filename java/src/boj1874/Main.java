package boj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int[] data = IntStream.range(0, n)
                .map(it -> Integer.parseInt(readLine()))
                .toArray();

        Stack<Integer> stack = new Stack<>();
        List<Character> answer = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < n; i++) {
            int target = data[i];

            while (count <= target) {
                stack.push(count);
                answer.add('+');
                count += 1;
            }

            if (stack.peek() == target) {
                stack.pop();
                answer.add('-');
                continue;
            }

            answer.add('!');
        }

        if (answer.contains('!')) {
            System.out.println("NO");
            return;
        }

        for (char e : answer) {
            System.out.println(e);
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

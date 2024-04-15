import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10773 {

    public static void main(String[] args) {
        int n = Console.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Console.nextInt();
        }

        int answer = solution(n, data);
        displayResult(answer);
    }

    public static int solution(int n, int[] data) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int target = data[i];

            if (target == 0) {
                stack.pop();
                continue;
            }

            stack.add(target);
        }

        return stack.stream()
                .mapToInt(it -> it)
                .sum();
    }

    public static void displayResult(int answer) {
        System.out.println(answer);
    }

    public static class Console {

        private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static int nextInt() {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

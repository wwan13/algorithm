import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15886 {

    public static void main(String[] args) {
        int n = Console.nextInt();
        char[] data = Console.readArray(n);

        int answer = solution(n, data);

        displayResult(answer);
    }

    public static int solution(int n, char[] data) {
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            if (data[i] == 'E' && data[i + 1] == 'W') {
                answer += 1;
            }
        }
        return answer;
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

        public static String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static char[] readArray(int size) {
            char[] data = new char[size];
            String line = Console.readLine();
            for (int i = 0; i < size; i++) {
                data[i] = line.charAt(i);
            }
            return data;
        }
    }
}

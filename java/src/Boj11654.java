import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11654 {

    public static void main(String[] args) {
        char input = Console.readLine().charAt(0);
        int answer = solution(input);
        displayResult(answer);
    }

    public static int solution(char input) {
        return (int) input;
    }

    public static void displayResult(int answer) {
        System.out.println(answer);
    }

    public static class Console {

        private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package boj10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        int n = Console.nextInt();
        for (int i = 0; i < n; i++) {
            String[] input = Console.readLine().split(" ");
            int answer = solution(
                    Integer.parseInt(input[0]),
                    Integer.parseInt(input[1]),
                    Integer.parseInt(input[2])
            );
            displayResult(answer);
        }
    }

    public static int solution(int h, int w, int n) {
        int floor = 0;
        int room = 0;

        if (n % h == 0) {
            floor = h;
            room = n / h;

            return floor * 100 + room;
        }

        floor = n % h;
        room = n / h + 1;

        return floor * 100 + room;
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
    }
}

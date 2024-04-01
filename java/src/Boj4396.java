import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj4396 {

    public static void main(String[] args) {
        int n = Console.nextInt();
        char[][] originalMap = Console.readDoubleArray(n, n);
        char[][] openedMap = Console.readDoubleArray(n, n);

        char[][] answer = solution(n, originalMap, openedMap);

        displayResult(answer);
    }

    private static char[][] solution(int n, char[][] originalMap, char[][] openedMap) {

        Console.print(String.valueOf(originalMap[0][4]));

        char[][] answer = new char[n][n];
        return answer;
    }

    private static void displayResult(char[][] answer) {

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

        public static char[][] readDoubleArray(int rowSize, int columnSize) {
            char[][] data = new char[rowSize][columnSize];
            for (int i = 0; i < rowSize; i++) {
                String line = Console.readLine();
                for (int j = 0; j < columnSize; j++) {
                    data[i][j] = line.charAt(j);
                }
            }
            return data;
        }

        public static void print(String data) {
            System.out.println(data);
        }
    }
}
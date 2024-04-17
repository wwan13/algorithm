import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2563 {

    public static void main(String[] args) {
        int n = Console.nextInt();
        int[][] data = Console.readIntDoubleArray(n, 2);

        int answer = solution(n, data);
        displayResult(answer);
    }

    public static int solution(int n, int[][] data) {
        final int PAPER_SIZE = 100;
        final int COLOR_PAPER_SIZE = 10;

        int[][] paper = new int[PAPER_SIZE][PAPER_SIZE];

        for (int[] target : data) {
            int xStart = target[0];
            int yStart = target[1];

            for (int i = 0; i < COLOR_PAPER_SIZE; i++) {
                for (int j = 0; j < COLOR_PAPER_SIZE; j++) {
                    paper[yStart + j][xStart + i] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < PAPER_SIZE; i++) {
            for (int j = 0; j < PAPER_SIZE; j++) {
                answer += paper[i][j];
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

        public static int[][] readIntDoubleArray(int rowSize, int columnSize) {
            int[][] data = new int[rowSize][columnSize];
            for (int i = 0; i < rowSize; i++) {
                String[] line = Console.readLine().split(" ");
                for (int j = 0; j < columnSize; j++) {
                    data[i][j] = Integer.parseInt(line[j]);
                }
            }
            return data;
        }
    }
}

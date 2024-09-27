package boj4396;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        int n = Console.nextInt();
        char[][] originalMap = Console.readDoubleArray(n, n);
        char[][] openedMap = Console.readDoubleArray(n, n);

        char[][] answer = solution(n, originalMap, openedMap);

        displayResult(answer);
    }

    private static char[][] solution(int n, char[][] originalMap, char[][] openedMap) {

        final char MINE = '*';
        final char NOT_MINE = '.';

        final char OPENED = 'x';
        final char NOT_OPENED = '.';

        char[][] answer = new char[n][n];

        boolean isCleared = false;

        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (openedMap[i][j] == OPENED) {
                    char target = originalMap[i][j];
                    if (target == MINE) {
                        isCleared = true;
                        continue;
                    }

                    int count = 0;
                    for (int k = 0; k < 8; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n)) {
                            if (originalMap[ny][nx] == MINE) {
                                count += 1;
                            }
                        }
                    }
                    answer[i][j] = Character.forDigit(count, 10);
                } else if (openedMap[i][j] == NOT_OPENED) {
                    answer[i][j] = NOT_OPENED;
                }
            }
        }

        if (isCleared) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (originalMap[i][j] == MINE) {
                        answer[i][j] = MINE;
                    }
                }
            }
        }

        return answer;
    }

    private static void displayResult(char[][] answer) {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                Console.print(String.valueOf(answer[i][j]));
            }
            Console.lineBreak();
        }
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
            System.out.print(data);
        }

        public static void lineBreak() {
            System.out.print("\n");
        }
    }
}
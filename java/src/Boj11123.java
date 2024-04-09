import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj11123 {

    static final char SHEEP = '#';
    static final char GRASS = '.';

    public static void main(String[] args) {
        int n = Console.nextInt();
        for (int i = 0; i < n; i++) {
            int[] heightAndWidth = Console.readIntArray(2);
            int height = heightAndWidth[0];
            int width = heightAndWidth[1];
            char[][] data = Console.readDoubleArray(height, width);

            int answer = solution(height, width, data);

            displayResult(answer);
        }
    }

    public static int solution(int height, int width, char[][] data) {
        int answer = 0;

        boolean[][] visited = new boolean[height][width];

        final int[] dy = {0, 0, 1, -1};
        final int[] dx = {1, -1, 0, 0};

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (data[i][j] == GRASS || visited[i][j]) {
                    visited[i][j] = true;
                    continue;
                }

                visited[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int ny = current[0] + dy[k];
                        int nx = current[1] + dx[k];

                        if ((nx >= 0 && nx < width) && (ny >= 0 && ny < height) &&
                                !visited[ny][nx] && data[ny][nx] == SHEEP) {
                            visited[ny][nx] = true;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }
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

        public static int[] readIntArray(int size) {
            int[] data = new int[size];
            String[] line = Console.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                data[i] = Integer.parseInt(line[i]);
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
    }
}

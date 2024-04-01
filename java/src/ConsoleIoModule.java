import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIoModule {

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
            String line = Boj4396.Console.readLine();
            for (int i = 0; i < size; i++) {
                data[i] = line.charAt(i);
            }
            return data;
        }

        public static char[][] readDoubleArray(int rowSize, int columnSize) {
            char[][] data = new char[rowSize][columnSize];
            for (int i = 0; i < rowSize; i++) {
                String line = Boj4396.Console.readLine();
                for (int j = 0; j < columnSize; j++) {
                    data[i][j] = line.charAt(j);
                }
            }
            return data;
        }

        public static void print(String data) {
            System.out.println(data);
        }

        public static void lineBreak() {
            System.out.print("\n");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1475 {

    public static void main(String[] args) {
        int[] roomNumber = Console.readIntArray();
        int answer = solution(roomNumber);
        displayResult(answer);
    }

    public static int solution(int[] roomNumber) {
        int[] count = new int[10];

        for (int e : roomNumber) {
            if (e == 6) {
                count[9] += 1;
                continue;
            }
            count[e] += 1;
        }

        count[9] = (int) Math.ceil((double) count[9] / 2);

        return Arrays.stream(count).max().getAsInt();
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

        public static int[] readIntArray() {
            String[] line = Console.readLine().split("");
            int[] data = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                data[i] = Integer.parseInt(line[i]);
            }
            return data;
        }
    }
}

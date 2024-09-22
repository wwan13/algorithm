import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Boj17204 {

    public static void main(String[] args) throws Exception {
        String[] nk = ConsoleReader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        List<Integer> data = new ArrayList<>();
        IntStream.range(0, n).forEach(it -> {
            int target = Integer.parseInt(ConsoleReader.readLine());
            data.add(target);
        });

        int memory = 0;
        for (int i = 0; i < n; i++) {
            int target = data.get(memory);
            if (target == k) {
                System.out.println(i + 1);
                return;
            }
            memory = target;
        }

        System.out.println("-1");
    }

    private static class ConsoleReader {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        static String readLine() {
            try {
                return reader.readLine().trim();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Boj1966 {

    public static void main(String[] args) {
        int t = Console.nextInt();
        for (int i = 0; i < t; i++) {
            int[] nm = Console.readIntArray(2, " ");
            int n = nm[0];
            int m = nm[1];
            int[] data = Console.readIntArray(n, " ");

            int answer = solution(n, m, data);
            displayResult(answer);
        }
    }

    static class Job {
        final boolean isTarget;
        final int priority;

        public Job(boolean isTarget, int priority) {
            this.isTarget = isTarget;
            this.priority = priority;
        }
    }

    public static int solution(int n, int m, int[] priority) {
        Queue<Job> queue = new LinkedList<>();
        IntStream.range(0, n)
                .mapToObj(i -> {
                    if (i == m) {
                        return new Job(true, priority[i]);
                    }
                    return new Job(false, priority[i]);
                })
                .forEach(queue::offer);

        int answer = 0;

        while (!queue.isEmpty()) {
            Job current = queue.poll();

            if (queue.stream().anyMatch(it -> it.priority > current.priority)) {
                queue.offer(current);
                continue;
            }

            answer += 1;
            if (current.isTarget) {
                break;
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

        public static int[] readIntArray(int size, String regex) {
            int[] data = new int[size];
            String[] line = Console.readLine().split(regex);
            for (int i = 0; i < size; i++) {
                data[i] = Integer.parseInt(line[i]);
            }
            return data;
        }
    }
}

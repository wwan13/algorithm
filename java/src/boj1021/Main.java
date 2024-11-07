package boj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] data = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            deque.offer(i);
        }

        int count = 0;

        for (int target : data) {
            int index = deque.indexOf(target);

            if (index <= deque.size() / 2) {
                while (deque.peek() != target) {
                    deque.offerLast(deque.pollFirst());
                    count += 1;
                }
            } else {
                while (deque.peek() != target) {
                    deque.offerFirst(deque.pollLast());
                    count += 1;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

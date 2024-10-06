package boj5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final char COMMAND_REVERSE = 'R';
    private static final char COMMAND_DELETE = 'D';

    public static void main(String[] args) {
        final int t = Integer.parseInt(readLine());

        for (int test = 0; test < t; test++) {

            final char[] commands = readLine().toCharArray();
            final int n = Integer.parseInt(readLine());
            final Deque<Integer> data = deserialize(readLine());

            boolean isReversed = false;
            boolean hasError = false;

            for (char command : commands) {
                if (command == COMMAND_REVERSE) {
                    isReversed = !isReversed;
                }

                if (command == COMMAND_DELETE) {
                    if (data.isEmpty()) {
                        System.out.println("error");
                        hasError = true;
                        break;
                    }
                    if (isReversed) {
                        data.removeLast();
                    }
                    if (!isReversed) {
                        data.removeFirst();
                    }
                }
            }

            if (!hasError) {
                System.out.println(serialize(data, isReversed));
            }
        }
    }

    private static Deque<Integer> deserialize(String line) {
        Deque<Integer> deque = new LinkedList<>();

        if (line.equals("[]")) {
            return deque;
        }

        Arrays.stream(line.substring(1, line.length() - 1).split(","))
                .map(Integer::parseInt)
                .forEach(deque::add);

        return deque;
    }

    private static String serialize(Deque<Integer> data, boolean isReversed) {
        List<String> parsed = data.stream().map(String::valueOf).collect(Collectors.toList());
        if (isReversed) {
            Collections.reverse(parsed);
        }
        String joined = String.join(",", parsed);
        return "[" + joined + "]";
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

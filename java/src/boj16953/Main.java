package boj16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] startTarget = readLine().split(" ");
        long start = Long.parseLong(startTarget[0]);
        long target = Long.parseLong(startTarget[1]);

        System.out.println(dfs(start, target, 1));
    }

    private static int dfs(long current, long target, int count) {
        if (current == target) {
            return count;
        }

        if (current > target) {
            return -1;
        }

        int multiple = dfs(current * 2, target, count + 1);
        int append = dfs(current * 10 + 1, target, count + 1);

        if (multiple == -1 && append == -1) {
            return -1;
        }

        if (multiple == -1) {
            return append;
        }

        if (append == -1) {
            return multiple;
        }

        return Math.min(multiple, append);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package boj1822;

import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {

        StringTokenizer tokenizer = new StringTokenizer(readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Set<Integer> nSet = new HashSet<>();
        tokenizer = new StringTokenizer(readLine());
        for (int i = 0; i < n; i++) {
            nSet.add(Integer.parseInt(tokenizer.nextToken()));
        }

        Set<Integer> mSet = new HashSet<>();
        tokenizer = new StringTokenizer(readLine());
        for (int i = 0; i < m; i++) {
            mSet.add(Integer.parseInt(tokenizer.nextToken()));
        }

        nSet.removeAll(mSet);

        if (nSet.isEmpty()) {
            write("0\n");
        } else {
            TreeSet<Integer> sortedSet = new TreeSet<>(nSet);
            write(sortedSet.size() + "\n");
            for (int value : sortedSet) {
                write(value + " ");
            }
        }

        flush();
        close();
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(String value) {
        try {
            writer.write(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void flush() {
        try {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void close() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

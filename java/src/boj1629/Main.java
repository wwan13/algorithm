package boj1629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] abc = readLine().split(" ");
        long a = Long.parseLong(abc[0]);
        long b = Long.parseLong(abc[1]);
        long c = Long.parseLong(abc[2]);

        System.out.println(remainder(a, b, c));
    }

    private static long remainder(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long halfVal = remainder(a, b / 2, c);

        if (b % 2 == 1) {
            return (halfVal * halfVal % c) * a % c;
        }

        return halfVal * halfVal % c;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

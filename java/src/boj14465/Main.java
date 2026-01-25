package boj14465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nkb = reader.readLine().split(" ");
        int n = Integer.parseInt(nkb[0]);
        int k = Integer.parseInt(nkb[1]);
        int b = Integer.parseInt(nkb[2]);

        boolean[] broken = new boolean[n];
        for (int i = 0; i < b; i++) {
            broken[Integer.parseInt(reader.readLine()) - 1] = true;
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            if (broken[i]) count++;
        }

        int min = count;

        for (int i = 1; i <= n - k; i++) {
            if (broken[i - 1]) count--;
            if (broken[i + k - 1]) count++;

            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}
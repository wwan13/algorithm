package boj6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int k;
    static int[] set;
    static int[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = reader.readLine();
            if (line.equals("0")) break;

            String[] split = line.split(" ");
            k = Integer.parseInt(split[0]);

            set = new int[k];
            memory = new int[6];

            for (int i = 0; i < k; i++) {
                set[i] = Integer.parseInt(split[i + 1]);
            }

            dfs(0, 0);

            System.out.println();
        }
    }

    private static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(memory[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            memory[depth] = set[i];
            dfs(depth + 1, i + 1);
        }
    }
}
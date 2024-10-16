package boj16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static Egg[] eggs;
    private static int answer;

    static class Egg {
        int power;
        final int weight;

        Egg(int power, int weight) {
            this.power = power;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        eggs = new Egg[n];
        answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] line = readLine().split(" ");
            int power = Integer.parseInt(line[0]);
            int weight = Integer.parseInt(line[1]);

            eggs[i] = new Egg(power, weight);
        }

        backtracking(0);

        System.out.println(answer);
    }

    private static void backtracking(int current) {
        if (current == eggs.length) {
            int count = 0;
            for (Egg egg : eggs) {
                if (egg.power <= 0) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
            return;
        }

        if (eggs[current].power <= 0) {
            backtracking(current + 1);
            return;
        }

        boolean anyHit = false;
        for (int i = 0; i < eggs.length; i++) {
            if (i != current && eggs[i].power > 0) {
                eggs[current].power -= eggs[i].weight;
                eggs[i].power -= eggs[current].weight;
                anyHit = true;

                backtracking(current + 1);

                eggs[current].power += eggs[i].weight;
                eggs[i].power += eggs[current].weight;
            }
        }

        if (!anyHit) {
            backtracking(current + 1);
        }
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

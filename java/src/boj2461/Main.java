package boj2461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Player {
        final int skill;
        final int team;
        final int index;

        Player(int skill, int team, int index) {
            this.skill = skill;
            this.team = team;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            data[i] = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
        }

        PriorityQueue<Player> pq = new PriorityQueue<>(Comparator.comparing(it -> it.skill));
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            pq.offer(new Player(data[i][0], i, 0));
            max = Math.max(max, data[i][0]);
        }

        int answer = Integer.MAX_VALUE;

        while (true) {
            Player current = pq.poll();
            int min = current.skill;
            answer = Math.min(answer, max - min);

            if (current.index + 1 >= m) {
                break;
            }

            Player nextPlayer = new Player(data[current.team][current.index + 1], current.team, current.index + 1);
            pq.offer(nextPlayer);
            max = Math.max(max, nextPlayer.skill);
        }

        System.out.println(answer);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

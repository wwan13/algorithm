package boj1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int[] parents;

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[] reals = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (reals[0] == 0) {
            System.out.println(m);
            return;
        }
        reals = Arrays.copyOfRange(reals, 1, reals.length);

        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        int[][] partyPeople = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] people = Arrays.stream(readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            people = Arrays.copyOfRange(people, 1, people.length);
            partyPeople[i] = people;

            for (int j = 1; j < people.length; j++) {
                union(people[0], people[j]);
            }
        }

        boolean[] knowsTruth = new boolean[n + 1];
        for (int person : reals) {
            knowsTruth[find(person)] = true;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean hasTruth = false;

            for (int j = 0; j < n; j++) {
                if (partyPeople[i][j] == 0) {
                    continue;
                }
                if (knowsTruth[find(partyPeople[i][j])]) {
                    hasTruth = true;
                    break;
                }
            }

            if (!hasTruth) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int find(int x) {
        if (parents[x] != x) {
            parents[x] = find(parents[x]);
        }

        return parents[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parents[rootY] = parents[rootX];
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

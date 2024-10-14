package boj1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final char DEFAULT = '.';

    private static char[] data;
    private static char[] memory;
    private static boolean[] visited;

    public static void main(String[] args) {
        String[] lc = readLine().split(" ");
        int l = Integer.parseInt(lc[0]);
        int c = Integer.parseInt(lc[1]);

        data = new char[c];
        memory = new char[l];
        visited = new boolean[26];

        data = readLine().replace(" ", "").toCharArray();
        Arrays.sort(data);

        Arrays.fill(memory, DEFAULT);

        backTracking(l, 0, 0);
    }

    private static void backTracking(int l, int count, int start) {
        if (l == count) {
            int vowels = 0;
            int consonants = 0;

            for (char value : memory) {
                if (isVowel(value)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }

            if (vowels >= 1 && consonants >= 2) {
                System.out.println(new String(memory));
            }
            return;
        }

        for (int i = start; i < data.length; i++) {
            char value = data[i];
            if (!visited[value - 'a']) {
                visited[value - 'a'] = true;
                memory[count] = value;
                backTracking(l, count + 1, i + 1);
                visited[value - 'a'] = false;
            }
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

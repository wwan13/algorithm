package boj17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, String> passwords = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = readLine().split(" ");
            passwords.put(line[0], line[1]);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(passwords.get(readLine()));
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

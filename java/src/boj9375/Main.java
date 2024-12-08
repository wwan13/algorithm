package boj9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(readLine());
            HashMap<String, Integer> clothes = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] input = readLine().split(" ");
                String type = input[1];
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int combinations = 1;
            for (int count : clothes.values()) {
                combinations *= (count + 1);
            }

            System.out.println(combinations - 1);
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

package boj7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        Set<String> company = new HashSet<>();

        while (n-- > 0) {
            String[] line = readLine().split(" ");
            String name = line[0];
            String command = line[1];

            switch (command) {
                case "enter":
                    company.add(name);
                    break;
                case "leave":
                    company.remove(name);
                    break;
            }
        }

        company.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

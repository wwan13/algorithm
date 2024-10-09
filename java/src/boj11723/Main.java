package boj11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int m = Integer.parseInt(readLine());

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            String line = readLine();

            if (line.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
                continue;
            }

            if (line.equals("empty")) {
                set.clear();
                continue;
            }

            String[] commandValue = line.split(" ");
            String command = commandValue[0];
            int value = Integer.parseInt(commandValue[1]);

            if (command.equals("add")) {
                set.add(value);
            }

            if (command.equals("remove")) {
                set.remove(value);
            }

            if (command.equals("check")) {
                if (set.contains(value)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }

            if (command.equals("toggle")) {
                if (set.contains(value)) {
                    set.remove(value);
                } else {
                    set.add(value);
                }
            }
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

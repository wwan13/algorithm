package boj13414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] kl = readLine().split(" ");
        int k = Integer.parseInt(kl[0]);
        int l = Integer.parseInt(kl[1]);

        LinkedHashSet<String> queue = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String studentNumber = readLine();
            if (queue.contains(studentNumber)) {
                queue.remove(studentNumber);
            }
            queue.add(studentNumber);
        }

        int count = 0;
        for (String student : queue) {
            System.out.println(student);
            if (++count == k) break;
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

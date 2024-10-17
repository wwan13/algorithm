package boj5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int t = Integer.parseInt(readLine());

        while (t-- > 0) {
            char[] data = readLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            int index = 0;

            for (char d : data) {
                switch (d) {
                    case '<':
                        if (index - 1 >= 0) {
                            index -= 1;
                        }
                        break;
                    case '>':
                        if (index + 1 <= sb.length()) {
                            index += 1;
                        }
                        break;
                    case '-':
                        if (index - 1 >= 0) {
                            sb.deleteCharAt(index - 1);
                            index -= 1;
                        }
                        break;
                    default:
                        sb.insert(index, d);
                        index += 1;
                        break;
                }
            }

            System.out.println(sb);
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

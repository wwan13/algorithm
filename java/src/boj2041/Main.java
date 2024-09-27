package boj2041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String input = Console.readLine();
        int answer = solution(input);
        displayResult(answer);
    }

    public static int solution(String input) {
        List<String> croatiaAlphabets = List.of("dz=", "lj", "nj", "c=", "c-", "d-", "s=", "z=");
        int answer = 0;

        while (true) {
            boolean isReplaced = false;
            for (String alphabet : croatiaAlphabets) {
                if (input.contains(alphabet)) {
                    if (alphabet.equals("z=")) {
                        if(input.contains("dz=")) {
                            answer += 1;
                            isReplaced = true;
                            input = input.replaceFirst("dz=", "@");
                            continue;
                        }
                    }

                    answer += 1;
                    isReplaced = true;
                    input = input.replaceFirst(alphabet, "@");
                }
            }
            if (!isReplaced) {
                break;
            }
        }

        input = input.replaceAll("@", "");
        answer += input.length();

        return answer;
    }

    public static void displayResult(int answer) {
        System.out.println(answer);
    }

    public static class Console {

        private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

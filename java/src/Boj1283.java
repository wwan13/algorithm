import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Boj1283 {

    public static void main(String[] args) {
        int n = Console.nextInt();
        String[] datas = new String[n];
        for (int i = 0; i < n; i++) {
            String data = Console.readLine();
            datas[i] = data;
        }

        String[] answer = solution(n, datas);

        displayResult(answer);
    }

    public static String[] solution(int n, String[] datas) {

        String[] answer = new String[n];
        Set<Character> shortcuts = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String target = datas[i];
            boolean isSaved = false;

            String[] words = target.split(" ");
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                char shortcut = word.charAt(0);
                if (!containsShortcut(shortcuts, shortcut)) {
                    shortcuts.add(shortcut);
                    words[j] = toAnswerFormat(word, shortcut);
                    answer[i] = String.join(" ", words);
                    isSaved = true;
                    break;
                }
            }

            if (!isSaved) {
                for (int j = 0; j < target.length(); j++) {
                    char shortcut = target.charAt(j);
                    if (shortcut != ' ' && !containsShortcut(shortcuts, shortcut)) {
                        shortcuts.add(shortcut);
                        answer[i] = toAnswerFormat(target, shortcut);
                        isSaved = true;
                        break;
                    }
                }
            }

            if (!isSaved) {
                answer[i] = target;
            }
        }

        return answer;
    }

    private static boolean containsShortcut(Set<Character> shortcuts, char shortcut) {
        return shortcuts.contains(Character.toUpperCase(shortcut)) ||
                shortcuts.contains(Character.toLowerCase(shortcut));
    }

    private static String toAnswerFormat(String original, char shortcut) {
        return original.replaceFirst(String.valueOf(shortcut), String.format("[%c]", shortcut));
    }

    public static void displayResult(String[] answer) {
        for (String element : answer) {
            Console.print(element);
        }
    }

    public static class Console {

        private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static int nextInt() {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void print(String data) {
            System.out.println(data);
        }
    }
}

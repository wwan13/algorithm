package boj5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class TrieNode {

        TrieNode[] children = new TrieNode[10];
        boolean isEndOfNumber = false;

        boolean insert(String number) {
            TrieNode node = this;

            for (int i = 0; i < number.length(); i++) {
                int index = number.charAt(i) - '0';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];

                if (node.isEndOfNumber) {
                    return false;
                }
            }
            node.isEndOfNumber = true;
            for (TrieNode child : node.children) {
                if (child != null) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        final int t = Integer.parseInt(readLine());

        for (int c = 0; c < t; c++) {
            final int n = Integer.parseInt(readLine());
            TrieNode root = new TrieNode();
            boolean consistent = true;

            for (int i = 0; i < n; i++) {
                String phone = readLine();
                if (!root.insert(phone)) {
                    consistent = false;
                }
            }

            if (consistent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
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

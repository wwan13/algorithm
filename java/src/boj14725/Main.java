package boj14725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        Map<String, Node> children = new TreeMap<>();
    }

    static class Trie {
        Node root = new Node();

        void insert(String[] values) {
            Node current = root;
            for (String value : values) {
                current.children.putIfAbsent(value, new Node());
                current = current.children.get(value);
            }
        }

        void display() {
            displayEach(this.root, 0);
        }

        private void displayEach(Node current, int depth) {
            for (String key : current.children.keySet()) {
                for (int i = 0; i < depth; i++) {
                    System.out.print("--");
                }
                System.out.println(key);
                displayEach(current.children.get(key), depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            String[] lines = readLine().split(" ");
            String[] information = Arrays.copyOfRange(lines, 1, lines.length);
            trie.insert(information);
        }

        trie.display();
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

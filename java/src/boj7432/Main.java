package boj7432;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class TrieNode {
        Map<String, TrieNode> children = new TreeMap<>();
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String[] values) {
            TrieNode current = root;

            for (String value : values) {
//                System.out.println(value);
                current.children.putIfAbsent(value, new TrieNode());
                current = current.children.get(value);
            }
        }

        void display(TrieNode root, int depth) {
            for (Map.Entry<String, TrieNode> entry : root.children.entrySet()) {
                for (int i = 0; i < depth; i++) {
                    System.out.print(" ");
                }
                System.out.println(entry.getKey());
                display(entry.getValue(), depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(readLine().split("\\\\"));
        }

        trie.display(trie.root, 0);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

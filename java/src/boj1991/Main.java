package boj1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final int DOT = '.' - 'A';

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        List<List<Node>> tree = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String[] line = readLine().split(" ");
            int target = toInt(line[0].charAt(0));
            int left = toInt(line[1].charAt(0));
            int right = toInt(line[2].charAt(0));

            tree.get(target).add(new Node(left, right));
        }

        preOrder(tree, 0);
        System.out.println();

        inOrder(tree, 0);
        System.out.println();

        postOrder(tree, 0);
        System.out.println();
    }

    static class Node {
        final int left;
        final int right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static void preOrder(List<List<Node>> tree, int start) {
        for (Node node : tree.get(start)) {
            System.out.print(toChar(start));
            if (node.left != DOT) {
                preOrder(tree, node.left);
            }
            if (node.right != DOT) {
                preOrder(tree, node.right);
            }
        }
    }

    static void inOrder(List<List<Node>> tree, int start) {
        for (Node node : tree.get(start)) {
            if (node.left != DOT) {
                inOrder(tree, node.left);
            }
            System.out.print(toChar(start));
            if (node.right != DOT) {
                inOrder(tree, node.right);
            }
        }
    }

    static void postOrder(List<List<Node>> tree, int start) {
        for (Node node : tree.get(start)) {
            if (node.left != DOT) {
                postOrder(tree, node.left);
            }
            if (node.right != DOT) {
                postOrder(tree, node.right);
            }
            System.out.print(toChar(start));
        }
    }

    static char toChar(int value) {
        return (char) (value + 'A');
    }

    static int toInt(char value) {
        return value - 'A';
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

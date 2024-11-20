package boj14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        int[] data = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(data[0]);

        int[] indexes = new int[n];

        for (int i = 1; i < n; i++) {
            int target = data[i];
            if (list.get(list.size() - 1) < target) {
                list.add(target);
                indexes[i] = list.size() - 1;
            } else {
                int index = indexOf(list, target);
                list.set(index, target);
                indexes[i] = index;
            }
        }

        Stack<Integer> stack = new Stack<>();
        int targetIndex = list.size() - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (indexes[i] == targetIndex) {
                targetIndex -= 1;
                stack.push(data[i]);
            }
        }

        System.out.println(list.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static int indexOf(ArrayList<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int compareTarget = list.get(middle);

            if (compareTarget < target) {
                start = middle + 1;
            } else if (compareTarget == target) {
                return middle;
            } else {
                end = middle - 1;
            }
        }

        return start;
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

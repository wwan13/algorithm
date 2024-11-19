package boj12738;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());
        long[] data = Arrays.stream(readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        ArrayList<Long> list = new ArrayList<>();
        list.add(data[0]);

        for (int i = 1; i < n; i++) {
            long target = data[i];
            if (list.get(list.size() - 1) < target) {
                list.add(target);
            } else {
                int index = indexOf(list, target);
                list.set(index, target);
            }
        }

        System.out.println(list.size());
    }

    private static int indexOf(ArrayList<Long> list, long target) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            long compareTarget = list.get(middle);
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

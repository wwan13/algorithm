package boj1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i <= 9; i++) {
            dfs(i, i);
        }

        Collections.sort(list);

        if (n >= list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(n));
        }
    }

    static void dfs(long num, int lastDigit) {
        list.add(num);

        for (int next = 0; next < lastDigit; next++) {
            dfs(num * 10 + next, next);
        }
    }
}
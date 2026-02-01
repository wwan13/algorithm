package boj3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // 차분 배열: 1..h 사용 (h+2까지 안전하게)
        int[] diff = new int[h + 2];

        for (int i = 0; i < n; i++) {
            int row = Integer.parseInt(reader.readLine());

            if (i % 2 == 0) { // 밑에서부터: 높이 1..row 구간에 +1
                diff[1] += 1;
                diff[row + 1] -= 1;
            } else { // 위에서부터: 높이 (h-row+1)..h 구간에 +1
                int start = h - row + 1;
                diff[start] += 1;
                diff[h + 1] -= 1;
            }
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        int cur = 0;
        for (int height = 1; height <= h; height++) {
            cur += diff[height];

            if (cur < min) {
                min = cur;
                count = 1;
            } else if (cur == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
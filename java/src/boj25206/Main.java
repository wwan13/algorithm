package boj25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        double sum = 0.0;
        int unitCount = 0;

        for (int i = 0; i < 20; i++) {
            String[] line = readLine().split(" ");
            double unit = Double.parseDouble(line[1]);
            Grade grade = Grade.resolve(line[2]);

            if (grade != Grade.PASS) {
                sum += grade.value * unit;
                unitCount += unit;
            }
        }

        double result = sum / unitCount;
        System.out.printf("%.6f", result);
    }

    enum Grade {
        A_PLUS("A+", 4.5),
        A_ZERO("A0", 4.0),
        B_PLUS("B+", 3.5),
        B_ZERO("B0", 3.0),
        C_PLUS("C+", 2.5),
        C_ZERO("C0", 2.0),
        D_PLUS("D+", 1.5),
        D_ZERO("D0", 1.0),
        FAil("F", 0),
        PASS("P", -1);

        Grade(String name, double value) {
            this.name = name;
            this.value = value;
        }

        final String name;
        final double value;

        static Grade resolve(String input) {
            return Arrays.stream(Grade.values())
                    .filter(it -> it.name.equals(input))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
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

package boj1924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] input = Console.readLine().split(" ");
        String answer = solution(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        displayResult(answer);
    }

    public static String solution(int month, int day) {
        int remainDay = Month.calculateRemainDaysOfWeek(month, day);
        return Day.getThisDay(remainDay).toString();
    }

    enum Day {
        MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

        Day(int remain) {
            this.remain = remain;
        }

        private final int remain;

        public static Day getThisDay(int value) {
            return Arrays.stream(values())
                    .filter(it -> it.remain == value)
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
        }
    }

    enum Month {
        JAN(1, 31), FEB(2, 28), MAR(3, 31),
        AFR(4, 30), MAY(5, 31), JUN(6, 30),
        JUl(7, 31), AUG(8, 31), SEP(9, 30),
        OCT(10, 31), NOV(11, 30), DEC(12, 31);

        Month(int value, int endOfMonth) {
            this.value = value;
            this.endOfMonth = endOfMonth;
        }

        private final int value;
        private final int endOfMonth;

        public static int calculateRemainDaysOfWeek(int month, int day) {
            int totalDaysBeforeInputMonth = Arrays.stream(values())
                    .filter(it -> it.value < month)
                    .mapToInt(it -> it.endOfMonth)
                    .sum();
            int totalDaysBelongToday = totalDaysBeforeInputMonth + day;
            return totalDaysBelongToday % 7;
        }
    }

    public static void displayResult(String answer) {
        System.out.println(answer);
    }

    public static class Console {

        private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

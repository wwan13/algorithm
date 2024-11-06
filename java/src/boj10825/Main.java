package boj10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static class Student {
        final String name;
        final int korean;
        final int english;
        final int math;

        Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public int getKorean() {
            return korean;
        }

        public int getEnglish() {
            return english;
        }

        public int getMath() {
            return math;
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = readLine().split(" ");
            Student student = new Student(
                    line[0],
                    Integer.parseInt(line[1]),
                    Integer.parseInt(line[2]),
                    Integer.parseInt(line[3])
            );
            students.add(student);
        }

        students.stream()
                .sorted(
                        Comparator.comparing(Student::getKorean, Comparator.reverseOrder())
                                .thenComparing(Student::getEnglish)
                                .thenComparing(Student::getMath, Comparator.reverseOrder())
                                .thenComparing(Student::getName)
                )
                .map(Student::getName)
                .forEach(System.out::println);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

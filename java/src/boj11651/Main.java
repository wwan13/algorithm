package boj11651;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(readLine());

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = readLine();
            Point point = Point.of(line);
            points.add(point);
        }

        points.stream()
                .sorted(Comparator.comparing(Point::getY).thenComparing(Point::getX))
                .forEach(it -> write(it.getX() + " " + it.getY() + "\n"));

        writer.flush();
        writer.close();
    }

    static class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        static Point of(String line) {
            String[] parsedLine = line.split(" ");
            int x = Integer.parseInt(parsedLine[0]);
            int y = Integer.parseInt(parsedLine[1]);

            return new Point(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void write(String value) {
        try {
            writer.write(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package boj2170;

import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        int n = Integer.parseInt(readLine());

        List<Point> points = IntStream.range(0, n)
                .mapToObj(it -> {
                    String[] xy = readLine().split(" ");
                    long x = Long.parseLong(xy[0]);
                    long y = Long.parseLong(xy[1]);
                    return new Point(x, y);
                })
                .sorted(
                        Comparator.comparing(Point::getX).thenComparing(Point::getY)
                )
                .collect(Collectors.toList());

        long result = 0;
        long previousEnd = Long.MIN_VALUE;
        for (Point point : points) {
            if (point.getX() > previousEnd) {
                result += point.getY() - point.getX();
                previousEnd = point.getY();
                continue;
            }

            if (point.getY() > previousEnd) {
                result += point.getY() - previousEnd;
                previousEnd = point.getY();
            }
        }

        System.out.println(result);
    }

    static class Point {
        final long x;
        final long y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
            return x;
        }

        public long getY() {
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
}

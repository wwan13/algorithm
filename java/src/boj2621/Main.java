package boj2621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Card {
        final char color;
        final int number;

        Card(char color, int number) {
            this.color = color;
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String[] line = reader.readLine().split(" ");
            cards.add(new Card(line[0].charAt(0), Integer.parseInt(line[1])));
        }

        // 정렬(숫자 기준)
        List<Card> sorted = cards.stream()
                .sorted(Comparator.comparingInt(card -> card.number))
                .collect(Collectors.toList());

        // 색 모두 같음?
        char firstColor = cards.get(0).color;
        boolean colorAllSame = cards.stream().allMatch(card -> card.color == firstColor);

        // 숫자 연속?
        boolean numberUp = true;
        for (int i = 1; i < 5; i++) {
            if (sorted.get(i).number != sorted.get(i - 1).number + 1) {
                numberUp = false;
                break;
            }
        }

        int maxNumber = sorted.get(4).number;

        // 숫자 카운트 맵
        Map<Integer, Integer> map = new HashMap<>();
        cards.forEach(card -> map.merge(card.number, 1, Integer::sum));

        // (1) 같은 색 + 연속
        if (colorAllSame && numberUp) {
            System.out.println(900 + maxNumber);
            return;
        }

        // (2) 4장 같은 숫자
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 4) {
                System.out.println(800 + entry.getKey());
                return;
            }
        }

        // (3) 3장 + 2장 (map.size()==2 이면서 {3,2})
        if (map.size() == 2) {
            int three = -1, two = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 3) three = entry.getKey();
                else if (entry.getValue() == 2) two = entry.getKey();
            }
            if (three != -1 && two != -1) {
                System.out.println(700 + three * 10 + two);
                return;
            }
        }

        // (4) 같은 색만 (연속은 아님)
        if (colorAllSame) {
            System.out.println(600 + maxNumber);
            return;
        }

        // (5) 연속만 (색은 다름 가능)
        if (numberUp) {
            System.out.println(500 + maxNumber);
            return;
        }

        // (6) 3장 같은 숫자
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3) {
                System.out.println(400 + entry.getKey());
                return;
            }
        }

        // (7) 2쌍
        if (map.size() == 3) { // 2쌍이면 숫자 종류가 3개
            List<Integer> pairs = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 2) pairs.add(entry.getKey());
            }
            if (pairs.size() == 2) {
                int a = Math.max(pairs.get(0), pairs.get(1));
                int b = Math.min(pairs.get(0), pairs.get(1));
                System.out.println(300 + a * 10 + b);
                return;
            }
        }

        // (8) 1쌍
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                System.out.println(200 + entry.getKey());
                return;
            }
        }

        // (9) 전부 다름
        System.out.println(100 + maxNumber);
    }
}
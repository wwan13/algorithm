package boj8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        List<Country> countries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            int id = Integer.parseInt(input[0]);
            int gold = Integer.parseInt(input[1]);
            int silver = Integer.parseInt(input[2]);
            int bronze = Integer.parseInt(input[3]);
            countries.add(new Country(id, gold, silver, bronze));
        }

        countries.sort(Comparator.comparing(Country::getGold, Comparator.reverseOrder())
                .thenComparing(Country::getSilver, Comparator.reverseOrder())
                .thenComparing(Country::getBronze, Comparator.reverseOrder()));

        int rank = 1;
        int actualRank = 1;
        Country previous = null;

        for (int i = 0; i < countries.size(); i++) {
            Country current = countries.get(i);

            if (previous != null) {
                if (!current.isTie(previous)) {
                    actualRank = rank;
                }
            }

            if (current.isSameCountry(k)) {
                System.out.println(actualRank);
                return;
            }

            previous = current;
            rank++;
        }
    }

    static class Country {
        int id, gold, silver, bronze;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int getGold() {
            return gold;
        }

        public int getSilver() {
            return silver;
        }

        public int getBronze() {
            return bronze;
        }

        public boolean isTie(Country target) {
            return this.gold == target.gold && this.silver == target.silver && this.bronze == target.bronze;
        }

        public boolean isSameCountry(int id) {
            return this.id == id;
        }
    }
}
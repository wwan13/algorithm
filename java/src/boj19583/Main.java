package boj19583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] line = readLine().split(" ");
        String start = line[0];
        String partyEnd = line[1];
        String streamingEnd = line[2];

        HashSet<String> attendedBeforeStart = new HashSet<>();
        HashSet<String> attendedAfterParty = new HashSet<>();

        String input;
        while ((input = readLine()) != null && !input.isEmpty()) {
            String[] log = input.split(" ");
            String time = log[0];
            String id = log[1];

            if (time.compareTo(start) <= 0) {
                attendedBeforeStart.add(id);
            } else if (time.compareTo(partyEnd) >= 0 && time.compareTo(streamingEnd) <= 0) {
                attendedAfterParty.add(id);
            }
        }

        int count = 0;
        for (String id : attendedBeforeStart) {
            if (attendedAfterParty.contains(id)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

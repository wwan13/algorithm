package boj16165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        String[] nm = readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Map<String, List<String>> groupMap = new HashMap<>();
        Map<String, String> memberMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String groupName = readLine();
            int memberCount = Integer.parseInt(readLine());

            List<String> members = new ArrayList<>();
            for (int j = 0; j < memberCount; j++) {
                String memberName = readLine();
                members.add(memberName);
                memberMap.put(memberName, groupName);
            }

            Collections.sort(members);
            groupMap.put(groupName, members);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String query = readLine();
            int queryType = Integer.parseInt(readLine());

            if (queryType == 0) {
                List<String> members = groupMap.get(query);
                for (String member : members) {
                    result.append(member).append("\n");
                }
            } else {
                result.append(memberMap.get(query)).append("\n");
            }
        }

        System.out.print(result);
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

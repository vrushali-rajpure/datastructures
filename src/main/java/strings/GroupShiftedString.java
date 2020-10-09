package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-shifted-strings/
 */
public class GroupShiftedString {

    public static List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> maps = new HashMap<>();

        for (String string : strings) {
            String key = getKey(string);

            final List<String> values = maps.getOrDefault(key, new ArrayList<>());

            values.add(string);

            maps.put(key, values);

        }

        return new ArrayList<>(maps.values());
    }

    private static String getKey(String string) {

        StringBuilder sb = new StringBuilder();
        sb.append(0);

        for (int i = 0; i < string.length() - 1; i++) {

            final int diff = string.charAt(i) - string.charAt(i + 1);
            if (string.charAt(i) < string.charAt(i + 1)) {
                sb.append(diff + 26);
            } else {
                sb.append(diff);
            }

        }
        return sb.toString();
    }
}

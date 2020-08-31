package challenges.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 *
 */
public class FourDigitTime {

    public String largestTimeFromDigits(int[] A) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            final int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }

        String hr = chooseHour(map);

        if(hr.equals("")){
            return "";
        }
        String min = chooseMinute(map);

        return (!min.equals("")) ? (hr+ ":" + min) : "";
    }

    private String chooseMinute(Map<Integer, Integer> map) {
        StringBuilder builder = new StringBuilder();
        boolean isSuccess = false;
        for (int i = 5; i >= 0; i--) {
            if (build(map, builder, i)) {
                isSuccess = true;
                break;
            }
        }
        if (!isSuccess) {
            return "";
        }
        isSuccess = false;

        for (int i = 9; i >= 0; i--) {
            if (build(map, builder, i)) {
                isSuccess = true;
                break;
            }
        }
        if (!isSuccess) {
            return "";
        }
        return builder.toString();
    }

    private String chooseHour(Map<Integer, Integer> map) {
        StringBuilder builder = new StringBuilder();
        boolean isSuccess = false;
        for (int i = 2; i >= 0; i--) {
            if (build(map, builder, i)) {
                isSuccess = true;
                break;
            }

        }

        if (!isSuccess) {
            return "";
        }

        isSuccess = false;
        if (builder.indexOf("2") != -1) {
            for (int i = 3; i >= 0; i--) {
                if (build(map, builder, i)) {
                    isSuccess = true;
                    break;
                }

            }
        } else {
            for (int i = 9; i >= 0; i--) {
                if (build(map, builder, i)) {
                    isSuccess = true;
                    break;
                }

            }
        }

        if (!isSuccess) {
            return "";
        }

        return builder.toString();
    }

    private boolean build(Map<Integer, Integer> map, StringBuilder builder, int i) {
        if (map.containsKey(i)) {
            builder.append(i);
            final Integer aDefault = map.getOrDefault(i, 0);
            if ((aDefault - 1) > 0) {
                map.put(i, aDefault - 1);
            } else {
                map.remove(i);
            }

            return true;
        }
        return false;
    }
}

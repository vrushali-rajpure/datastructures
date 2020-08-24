package challenges.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInt {
    static Map<Character, Integer> map = new HashMap<>();

    static {

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

    }

    public static int romanToInt(String s) {

        final char[] chars = s.toCharArray();
        Character previous = null;
        int sum = 0;
        for (final char aChar : chars) {
            final Integer integer = map.get(aChar);
            int correction = getCorrection(aChar, previous);

            previous = aChar;
            sum += (integer + correction);
        }

        return sum;

    }

    private static int getCorrection(Character current, Character prev) {
        if (prev == null) {
            return 0;
        }

        switch (prev) {
            case 'I':
                if (current == 'V' || current == 'X')
                    return (-1 + -1);
                return 0;
            case 'X':
                if (current == 'L' || current == 'C')
                    return (-10 + -10);
                return 0;

            case 'C':
                if (current == 'D' || current == 'M')
                    return (-100 + -100);
                return 0;
        }
        return 0;
    }



    int newSolution(String s) {
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = map.get(currentSymbol);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = map.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            } else {
                sum += currentValue;
                i += 1;
            }

        }
        return sum;
    }
}

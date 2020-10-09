package dynamicprogramming.medium;

import com.sun.tools.javac.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * https://leetcode.com/problems/decode-ways/
 *
 * </br>
 * <b>Explanation</b>
 *
 * Algorithm
 *
 * Algorithm
 *
 * Algorithm
 *
 *
 * If the string s is empty or null we return the result as 0.
 *
 *
 *
 * Initialize dp array. dp[0] = 1 to provide the baton to be passed.
 *
 *
 *
 * If the first character of the string is zero then no decode is possible hence initialize dp[1] to 0, otherwise the first character is
 * valid to pass on the baton, dp[1] = 1.
 *
 *
 *
 * Iterate the dp array starting at index 2. The index i of dp is the i-th character of the string s, that is character at index i-1 of s.
 *
 *
 *
 * We check if valid single digit decode is possible. This just means the character at index s[i-1] is non-zero. Since we do not have a
 * decoding for zero. If the valid single digit decoding is possible then we add dp[i-1] to dp[i]. Since all the ways up to (i-1)-th
 * character now lead up to i-th character too.
 *
 *
 *
 * We check if valid two digit decode is possible. This means the substring s[i-2]s[i-1] is between 10 to 26. If the valid two digit
 * decoding is possible then we add dp[i-2] to dp[i].
 *
 *
 *
 * Once we reach the end of the dp array we would have the number of ways of decoding string s.
 */
public class DecodeWays {

    public static int numDecodings(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }

        List<Integer> list = List.of(1,2);
        List<Integer> list1 = List.of(3,4);
        list.stream().collect(Collectors.toList());
        list.stream().collect(Collectors.toList());

//        Stream.of(li)
        System.out.println(list);


        // DP array to store the subproblem results
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < dp.length; i += 1) {

            // Check if successful single digit decode is possible.
            if(s.charAt(i-1) != '0') {
                dp[i] += dp[i-1];
            }

            // Check if successful two digit decode is possible.
            int twoDigit = Integer.valueOf(s.substring(i-2, i));
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];

    }
}

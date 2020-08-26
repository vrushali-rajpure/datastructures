package strings;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * https://leetcode.com/problems/backspace-string-compare/
 *
 */
public class BacksSpaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {

        String safter = removeBackslash(S);
        String tafter = removeBackslash(T);

        return safter.equals(tafter);
    }

    private static String removeBackslash(String s) {
        final char[] chars = s.toCharArray();
        final Stack<Character> newChars = new Stack<>();
        for (char aChar : chars) {
            if( !newChars.empty() && aChar == '#' ) {
                newChars.pop();
            } else {
                newChars.push(aChar);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!newChars.isEmpty()) {
            final Character pop = newChars.pop();
            if( pop != '#')
                sb.append(pop);
        }
        return sb.toString();
    }
}

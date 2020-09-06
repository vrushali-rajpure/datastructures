package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Backtracking is an algorithm for finding all solutions by exploring all potential candidates. If the solution candidate turns to be not a solution (or at least not the last one), backtracking algorithm discards it by making some changes on the previous step, i.e. backtracks and then try again.
 *
 * Here is a backtrack function backtrack(combination, next_digits) which takes as arguments an ongoing letter combination and the next digits to check.
 *
 * If there is no more digits to check that means that the current combination is done.
 * If there are still digits to check :
 * Iterate over the letters mapping the next available digit.
 * Append the current letter to the current combination combination = combination + letter.
 * Proceed to check next digits : backtrack(combination + letter, next_digits[1:])
 */
public class LetterCombinationOfPhoneNumber {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        backtrack("", digits);

        return output;
    }

    void backtrack(String combination, String next_digit) {

        System.out.println("combi:" + combination + "|next_digit:" + next_digit + "|output:" + output);
        if (next_digit.length() == 0) {
            output.add(combination);
        } else {
            final String digit = next_digit.substring(0, 1);
            final String s = phone.get(digit);
            for (int i = 0; i < s.length(); i++) {
                final String substring = s.substring(i, i + 1);
                backtrack(combination + substring, next_digit.substring(1));
            }
        }

    }

}

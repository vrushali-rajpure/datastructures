package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/solution/
 *
 * https://www.youtube.com/watch?v=N-3fyoKD8-k
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    private void generate(List<String> result, String current,
        int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            generate(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            generate(result, current + ")", open, close + 1, max);
        }
    }
}

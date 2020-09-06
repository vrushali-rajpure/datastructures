package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        final LinkedList<Integer> comb = new LinkedList<>();
        sum(candidates, target, result, comb, 0);
        return result;
    }

    private void sum(int[] candidates, int remain, List<List<Integer>> result, LinkedList<Integer> current, int start) {
        if (remain == 0) {
            // make a deep copy of the current combination
            result.add(new ArrayList<>(current));
        } else if (remain < 0) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                current.add(candidates[i]);
                sum(candidates, remain - candidates[i], result, current, i);
                // backtrack, remove the number from the combination
                System.out.println("Before Remove:" + current);
                current.removeLast();
                System.out.println("After Remove:" + current);
                System.out.println("---------------");
            }
        }

    }

}

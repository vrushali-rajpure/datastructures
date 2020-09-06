package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(list, 0, list.size(), result);

        return result;
    }

    private void backtrack(List<Integer> permuts, int l, int r, List<List<Integer>> result) {

        if (l == r) {
            result.add(new ArrayList<>(permuts));
        }

        System.out.println("permuts:" + permuts);
        System.out.println("l:" + l);
        System.out.println("r:" + r);

        System.out.println("\n");
        for (int i = l; i < r; i++) {

            // place i-th integer first
            // in the current permutation
            Collections.swap(permuts, l, i);
            System.out.println("first swap :" + permuts);
            // use next integers to complete the permutations
            backtrack(permuts, l + 1, r, result);
            // backtrack
            Collections.swap(permuts, l, i);
            System.out.println("last swap :" + permuts);
        }
        System.out.println("----------");
    }
//    public void backtrack(List<Integer> nums,
//        int first,
//        int n,
//        List<List<Integer>> output) {
//        // if all integers are used up
//        if (first == n)
//            output.add(new ArrayList<Integer>(nums));
//
//        for (int i = first; i < n; i++) {
//            // place i-th integer first
//            // in the current permutation
//            Collections.swap(nums, first, i);
//            // use next integers to complete the permutations
//            backtrack(nums, first + 1, n, output);
//            // backtrack
//            Collections.swap(nums, first, i);
//        }
//    }



}

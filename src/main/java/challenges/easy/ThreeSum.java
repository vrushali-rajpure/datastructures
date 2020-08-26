package challenges.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * https://leetcode.com/problems/3sum/
 */

/**
 * Solution Approach
 *
 * This problem is a follow-up of Two Sum, and it is a good idea to first take a look at Two Sum and Two Sum II. An interviewer may ask to solve Two Sum first, and then throw 3Sum at you. Pay attention to subtle differences in problem description and try to re-use existing solutions!
 *
 * Two Sum, Two Sum II and 3Sum share a similarity that the sum of elements must match the target exactly. A difference is that, instead of exactly one answer, we need to find all unique triplets that sum to zero.
 *
 * Before jumping in, let's check the existing solutions and determine the best conceivable runtime (BCR) for 3Sum:
 *
 * Two Sum uses a hashmap to find complement values, and therefore achieves \mathcal{O}(N)O(N) time complexity.
 * Two Sum II uses the two pointers pattern and also has \mathcal{O}(N)O(N) time complexity for a sorted array. We can use this approach for any array if we sort it first, which bumps the time complexity to \mathcal{O}(n\log{n})O(nlogn).
 * Considering that there is one more dimension in 3Sum, it sounds reasonable to shoot for \mathcal{O}(n^2)O(n
 * 2
 *  ) time complexity as our BCR.
 */
public class ThreeSum {

    /**
     * The implementation is straightforward - we just need to modify twoSumII to produce triplets and skip repeating values.
     *
     * For the main function:
     *
     * Sort the input array nums.
     * Iterate through the array:
     * If the current value is greater than zero, break from the loop. Remaining values cannot sum to zero.
     * If the current value is the same as the one before, skip it.
     * Otherwise, call twoSumII for the current position i.
     * For twoSumII function:
     *
     * Set the low pointer lo to i + 1, and high pointer hi to the last index.
     * While low pointer is smaller than high:
     * If sum of nums[i] + nums[lo] + nums[hi] is less than zero, increment lo.
     * If sum is greater than zero, decrement hi.
     * Otherwise, we found a triplet:
     * Add it to the result res.
     * Decrement hi and increment lo.
     * Increment lo while the next value is the same as before to avoid duplicates in the result.
     * Return the result res.
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int index = 0; index < nums.length && nums[index] <= 0; index++) {
            if (index == 0 || nums[index] != nums[index - 1]) {
//                sum2(nums, index, result);
                twoSumII(nums, index, result);
            }
        }
        return result;

    }

    private void sum2(int[] nums, int index, List<List<Integer>> result) {

//        int low = index + 1;
//        int high = nums.length - 1;
//        while (low < high) {
//            int sum = nums[low] + nums[high] + nums[index];
//            if (sum < 0) {
//                low++;
//            } else if (sum > 0) {
//                high++;
//            } else {
//                result.add(Arrays.asList(nums[index], nums[low++], nums[high++]));
//                while (low < high && nums[low] == nums[low - 1])
//                    ++low;
//            }
//        }

    }

    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }

    /**
     * What if you cannot modify the input array, and you want to avoid copying it due to memory constraints?
     *
     * We can adapt the hashset approach above to work for an unsorted array. We can put a combination of three values into a hashset to avoid duplicates. Values in a combination should be ordered (e.g. ascending). Otherwise, we can have results with the same values in the different positions.
     *
     * Algorithm
     *
     * The algorithm is similar to the hashset approach above. We just need to add few optimizations so that it works efficiently for repeated values:
     *
     * Use another hashset dups to skip duplicates in the outer loop.
     * Without this optimization, the submission will time out for the test case with 3,000 zeroes. This case is handled naturally when the array is sorted.
     * Instead of re-populating a hashset every time in the inner loop, we can use a hashmap and populate it once. Values in the hashmap will indicate whether we have encountered that element in the current iteration. When we process nums[j] in the inner loop, we set its hashmap value to i. This indicates that we can now use nums[j] as a complement for nums[i].
     * This is more like a trick to compensate for container overheads. The effect varies by language, e.g. for C++ it cuts the runtime in half. Without this trick the submission may time out.
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumWithNoSort(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.containsKey(complement) && seen.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        return new ArrayList(res);
    }
}

package challenges.easy;

/**
 * https://leetcode.com/problems/max-consecutive-ones/solution/
 */
public class MaxConsecutiveOnes {
    // int[] arr = {1,0,1,1,0,1};
    public static int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int count = 0, max = 0;
        while (i < nums.length) {
            boolean reset = false;
            if (nums[i] == 1) {
                count++;
            } else {
                reset = true;
            }
            max = Math.max(count, max);
            if (reset) {
                count = 0;
            }
            i++;
        }
        return max;
    }
}

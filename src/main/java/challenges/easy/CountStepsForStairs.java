package challenges.easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * https://leetcode.com/problems/climbing-stairs/solution/
 *
 */
public class CountStepsForStairs {

    /**
     * In this brute force approach we take all possible step combinations i.e. 1 and 2, at every step. At every step we are calling the function climbStairsclimbStairs for step 11 and 22, and return the sum of returned values of both functions.
     *
     * climbStairs(i,n)=(i + 1, n) + climbStairs(i + 2, n)climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n)
     *
     * where ii defines the current step and nn defines the destination step.
     * @param n
     * @return
     */
    public static int climbStairsBruteForce(int n) {
        return climb(0, n);

    }

    private static int climb(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb(i+1, n) + climb(i + 2, n);
    }

    /**
     * One can reach i^{th}i
     * th
     *   step in one of the two ways:
     *
     * Taking a single step from (i-1)^{th}(i−1)
     * th
     *   step.
     *
     * Taking a step of 22 from (i-2)^{th}(i−2)
     * th
     *   step.
     *
     * So, the total number of ways to reach i^{th}i
     * th
     *   is equal to sum of ways of reaching (i-1)^{th}(i−1)
     * th
     *   step and ways of reaching (i-2)^{th}(i−2)
     * th
     *   step.
     *
     * Let dp[i]dp[i] denotes the number of ways to reach on i^{th}i
     * th
     *   step:
     *
     * dp[i]=dp[i-1]+dp[i-2]dp[i]=dp[i−1]+dp[i−2]
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

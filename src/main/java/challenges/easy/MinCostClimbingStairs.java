package challenges.easy;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;

        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);

    }

    public int minCostClimbingStairsAnother(int[] cost) {

        int cost1 = cost[0];
        int cost2 = cost[1];

        int total = Math.min(cost1, cost2);

        for (int i = 2; i < cost.length; i++) {

        }
        return 0;
    }
}

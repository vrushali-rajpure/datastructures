package challenges.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinCostClimbingStairsTest {

    @Test
    public void minCostClimbingStairs() {

        MinCostClimbingStairs stairs = new MinCostClimbingStairs();
        final int climbingStairs = stairs.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});

        assertEquals(6,climbingStairs);
    }
}
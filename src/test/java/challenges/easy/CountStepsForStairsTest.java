package challenges.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountStepsForStairsTest {

    @Test
    public void countSteps() {
        final int steps = CountStepsForStairs.climbStairsBruteForce(4);
        assertEquals(5,steps);

    }
}
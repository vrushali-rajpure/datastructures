package divideAndConquer.challenges.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubArrayTest {

    @Test
    public void maxSubArray() {
        final int array = MaxSubArray.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4});

        assertEquals(6,array);
    }
}
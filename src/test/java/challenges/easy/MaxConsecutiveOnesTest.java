package challenges.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxConsecutiveOnesTest {

    @Test
    public void test() {
        int[] arr = {1,1,0,1};
        final int consecutiveOnes = MaxConsecutiveOnes.findMaxConsecutiveOnes(arr);
        assertEquals(2,consecutiveOnes);
    }
}
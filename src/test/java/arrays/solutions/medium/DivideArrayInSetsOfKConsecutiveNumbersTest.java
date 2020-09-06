package arrays.solutions.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivideArrayInSetsOfKConsecutiveNumbersTest {

    @Test
    public void isPossibleDivide() {

        int[] chars = new int[]{1,2,3,3,4,4,5,6};
        final boolean divide = DivideArrayInSetsOfKConsecutiveNumbers.isPossibleDivide(chars, 4);
        assertTrue(divide);
    }
}
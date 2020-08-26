package challenges.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreeSumTest {

    @Test
    public void threeSum() {
        ThreeSum sum = new ThreeSum();
        final List<List<Integer>> lists = sum.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        final List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1));
        assertEquals(expected,lists);
    }


}
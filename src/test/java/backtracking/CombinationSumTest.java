package backtracking;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationSumTest {

    @Test
    public void combinationSum() {

        CombinationSum sum = new CombinationSum();

        final List<List<Integer>> results = sum.combinationSum(new int[] {2, 3, 5}, 8);

        System.out.println(results);

        assertEquals(3,results.size());
    }
}
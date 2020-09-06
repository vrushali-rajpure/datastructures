package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationsTest {

    @Test
    public void permute() {
        Permutations permutations = new Permutations();
        final List<List<Integer>> lists = permutations.permute(new int[] {1, 2, 3});

        System.out.println(lists);
        assertEquals(6,lists.size());
    }


}
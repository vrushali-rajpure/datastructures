package sorting;

import org.junit.Assert;
import org.junit.Test;

public class WiggleSortTest {

    @Test
    public void wiggleSort() {

        WiggleSort sort = new WiggleSort();
        final int[] nums = {3,5,2,1,6,4};
        sort.wiggleSort(nums);

        Assert.assertArrayEquals(new int[] {3, 5, 1, 6, 2, 4}, nums);
    }
}
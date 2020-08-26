package arrays.solutions.medium;

import java.util.Arrays;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RemoveDuplicateInArrayIIITest {

    @Test
    public void removeDuplicates() {

        RemoveDuplicateInArrayIII r = new RemoveDuplicateInArrayIII();

        final int[] nums = {1, 1, 1, 2, 2, 3};
        final int duplicates = r.removeDuplicates(nums);

        int[] actual = Arrays
            .copyOfRange(
                nums, 0, duplicates );
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(new int[] {1, 1, 2, 2, 3}, actual);
    }

    @Test
    public void removeDuplicatesII() {

        RemoveDuplicateInArrayIII r = new RemoveDuplicateInArrayIII();

        final int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};

        final int duplicates = r.removeDuplicates(nums);

        int[] actual = Arrays
            .copyOfRange(
                nums, 0, duplicates );
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(new int[] {0, 0, 1, 1, 2, 3, 3}, actual);
    }
}
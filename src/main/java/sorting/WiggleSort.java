package sorting;

import java.util.Arrays;

public class WiggleSort {

    // complexity : O(nlogn)
    public void wiggleSort(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length - 1; i = i + 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSortOnePass(int[] nums) {

        boolean less = true;

        for (int i = 0; i < nums.length - 1; i = i + 2) {
            if (less) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            less = !less;
        }

        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

package arrays.easy;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 */
public class NumArray {

    int[] numbers ;
    public NumArray(int[] nums) {
        numbers = nums;
    }

    public void update(int i, int val) {
        numbers[i] = val;
    }

    public int sumRange(int i, int j) {
        if( i < 1 || j > numbers.length){
            return -1;
        }
        int sum = 0;
        for(int index = i; index <= j ; index++){
            sum += (numbers[index]);
        }
        return sum;
    }
}

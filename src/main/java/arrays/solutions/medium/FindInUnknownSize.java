package arrays.solutions.medium;

/**
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 *
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 *
 * Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
 *
 * You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.
 *
 *
 *
 * Example 1:
 *
 * Input: array = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 *
 * Input: array = [-1,0,3,5,9,12], target = 2
 * Output: -1
 */

interface ArrayReader {
      public int get(int index) ;
  }

public class FindInUnknownSize {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;

        // search boundaries
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1;
        }

        // binary search
        int pivot, num;
        while (left <= right) {
            pivot = left + ((right - left) >> 1);
            num = reader.get(pivot);

            if (num == target) return pivot;
            if (num > target) right = pivot - 1;
            else left = pivot + 1;
        }

        // there is no target element
        return -1;
    }
}

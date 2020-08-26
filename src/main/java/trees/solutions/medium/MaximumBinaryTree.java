package trees.solutions.medium;

import trees.BinaryTreeNode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 */
public class MaximumBinaryTree {
    public BinaryTreeNode constructMaximumBinaryTree(int[] nums) {

        return constructTree(nums, 0, nums.length);

    }

    BinaryTreeNode constructTree(int[] nums, int start, int end) {
//        final int index = findMaxIndex(nums);
        final int index = findMaxIndex(nums, start, end);

        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new BinaryTreeNode(nums[0]);
        }
        if (start == end) {
            return null;
        }
        if (index != -1) {
            final int max = nums[index];
            BinaryTreeNode node = new BinaryTreeNode(max);

            System.out.println(node);
//            node.left = constructTree(Arrays.copyOfRange(nums, 0, index),start,index);
//            node.right = constructTree(Arrays.copyOfRange(nums, index + 1, nums.length), index + 1, end);

            node.left = constructTree(nums, start, index);
            node.right = constructTree(nums, index + 1, end);

            return node;
        }
        return null;
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        if (nums.length == 0) {
            return -1;
        }
        int index = start;
        for (int i = start; i < end; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }
        return index;
    }

    private int findMaxIndex(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;

    }
}

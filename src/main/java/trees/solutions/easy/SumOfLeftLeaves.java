package trees.solutions.easy;

import trees.BinaryTreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree,
 * with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {

    public static int sumOfLeftLeaves(BinaryTreeNode root) {
        return leftSum(root, false);
    }

    private static int leftSum(BinaryTreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return isLeft ? root.data : 0;
        }
        return leftSum(root.left, true) + leftSum(root.right, false);
    }

}

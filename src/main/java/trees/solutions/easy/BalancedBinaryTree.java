package trees.solutions.easy;

import trees.BinaryTreeNode;

/**
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {

    public static boolean isBalanced(BinaryTreeNode root) {

        if (root == null) {
            return true;

        }
        return (Math.abs(depth(root.left) - depth(root.right))) < 2
            && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int depth(BinaryTreeNode root) {
        if (root == null) {
            return 0;

        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

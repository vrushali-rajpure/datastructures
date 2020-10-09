package trees.solutions.easy;

import trees.BinaryTreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree
 * is the length of the longest path between any two nodes
 * in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class DiameterBinaryTree {
    static int ans;

    public static int diameterOfBinaryTree(BinaryTreeNode root) {

        ans = 1;
        depth(root);
        return ans - 1;
    }

    static private int depth(BinaryTreeNode node) {
        if (node == null)
            return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}

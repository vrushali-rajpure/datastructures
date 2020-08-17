package trees.solutions.easy;

import java.util.Objects;
import trees.BinaryTreeNode;

/**
 * Example 1:
 *            1
 *      2           3
 *  4    5      null    7
 *
 */
public class MaxDepthOfBinaryTree {

    static BinaryTreeNode createInput() {
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        return new BinaryTreeNode(1, node2, node3);
    }

    public static void main(String[] args) {
        final int countNodes = new MaxDepthOfBinaryTree().depth(createInput());
        final boolean equals = Objects.equals(3, countNodes);
        System.out.println("Result :" + equals);
    }

    private int depth(BinaryTreeNode root) {
        System.out.println(root);
        if (root == null) {
            return 0;

        }
        final int max = Math.max(depth(root.getLeft()), depth(root.getRight()));
        System.out.println("height:" + max + ",root : " + root);
        return max + 1;
    }
}
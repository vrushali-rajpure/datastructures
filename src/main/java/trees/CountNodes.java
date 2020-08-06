package trees;

import java.util.Objects;

public class CountNodes {
    static BinaryTreeNode createInput() {
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);
        return new BinaryTreeNode(1, node2, node3);
    }

    public static void main(String[] args) {
        final int countNodes = new CountNodes().countNodes(createInput());
        System.out.println(countNodes);
        final boolean equals = Objects.equals(5, countNodes);
        System.out.println("Result :" + equals);
    }

    public int countNodes(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);

    }
}


package trees.solutions.easy;

import trees.BinaryTreeNode;

public class ReverseTree {

    public BinaryTreeNode invertTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        final BinaryTreeNode left = root.getLeft();
        final BinaryTreeNode right = root.getRight();
        root.setRight(left);
        root.setLeft(right);
        invertTree(left);
        invertTree(right);
        return root;
    }
}

package trees.solutions.easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import trees.BinarySearchTree;
import trees.BinaryTreeNode;
import trees.LevelOrderTraversal;

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

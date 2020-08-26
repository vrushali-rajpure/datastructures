package trees.solutions.medium;

import org.junit.Test;
import trees.BinaryTreeNode;

import static org.junit.Assert.*;

public class MaximumBinaryTreeTest {

    @Test
    public void constructMaximumBinaryTree() {
        MaximumBinaryTree tree = new MaximumBinaryTree();

        final BinaryTreeNode node = tree.constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5});
        System.out.println(node);
    }
}
package trees.solutions.easy;

import org.junit.Test;
import trees.BinaryTreeNode;

import static org.junit.Assert.*;

public class BalancedBinaryTreeTest {

    @Test
    public void balancedBinaryTree() {

        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, null);
        BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);

        assertTrue(BalancedBinaryTree.isBalanced(root));

    }

    @Test
    public void notBalancedBinaryTree() {

        BinaryTreeNode right4 = new BinaryTreeNode(4);
        BinaryTreeNode left4 = new BinaryTreeNode(4);
        BinaryTreeNode left3 = new BinaryTreeNode(3,left4,right4);
        BinaryTreeNode right3 = new BinaryTreeNode(3);
        BinaryTreeNode left1 = new BinaryTreeNode(2, left3, right3);
        BinaryTreeNode right = new BinaryTreeNode(2);
        BinaryTreeNode root = new BinaryTreeNode(1, left1, right);

        assertFalse(BalancedBinaryTree.isBalanced(root));

    }
}
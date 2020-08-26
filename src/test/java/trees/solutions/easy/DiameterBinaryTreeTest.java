package trees.solutions.easy;

import org.junit.Test;
import trees.BinaryTreeNode;

import static org.junit.Assert.*;

public class DiameterBinaryTreeTest {

    @Test
    public void test() {

        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);

        DiameterBinaryTree.diameterOfBinaryTree(root);
    }
}
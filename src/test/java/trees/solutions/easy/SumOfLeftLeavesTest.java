package trees.solutions.easy;

import org.junit.Test;
import trees.BinaryTreeNode;

import static org.junit.Assert.*;

public class SumOfLeftLeavesTest {

    @Test
    public void sumOfLeftLeaves() {
        BinaryTreeNode right = new BinaryTreeNode(20, new BinaryTreeNode(15), new BinaryTreeNode(7));
        BinaryTreeNode left = new BinaryTreeNode(9);
        BinaryTreeNode root = new BinaryTreeNode(3,  left,right);

        final int sumOfLeftLeaves = SumOfLeftLeaves.sumOfLeftLeaves(root);
        assertEquals(24,sumOfLeftLeaves);
    }
}
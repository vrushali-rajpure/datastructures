package trees.solutions.medium;

import org.junit.Test;
import trees.BinaryTreeNode;

import static org.junit.Assert.*;

public class FlipEquivalentBinaryTreesTest {

    @Test
    public void flipEquiv() {
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, null);
        BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);

        BinaryTreeNode node51 = new BinaryTreeNode(5);
        BinaryTreeNode node41 = new BinaryTreeNode(4);
        BinaryTreeNode node61 = new BinaryTreeNode(6);
        BinaryTreeNode node21 = new BinaryTreeNode(2,node41, node51);
        BinaryTreeNode node31 = new BinaryTreeNode(3,  null,node61);
        BinaryTreeNode root1 = new BinaryTreeNode(1, node31, node21);


        FlipEquivalentBinaryTrees trees = new FlipEquivalentBinaryTrees();

        final boolean flipEquiv = trees.flipEquiv(root, root1);
        assertTrue(flipEquiv);
    }
}
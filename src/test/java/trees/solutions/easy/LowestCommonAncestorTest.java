package trees.solutions.easy;

import org.junit.Test;
import trees.BinaryTreeNode;

import static org.junit.Assert.*;

public class LowestCommonAncestorTest {

    @Test
    public void testLCA() {

        BinaryTreeNode n2 = new BinaryTreeNode(2);

        BinaryTreeNode n9 = new BinaryTreeNode(9);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n11 = new BinaryTreeNode(11,n9,n5);

        BinaryTreeNode n6 = new BinaryTreeNode(6,n2,n11);

        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n13 = new BinaryTreeNode(13,n7,null);
        BinaryTreeNode n8 = new BinaryTreeNode(8,null,n13);

        final BinaryTreeNode root = new BinaryTreeNode(3, n6, n8);

        assertEquals(6, LowestCommonAncestor.lca(root, n2, n6).data);
        assertEquals(3, LowestCommonAncestor.lca(root, n8, n11).data);

    }
}
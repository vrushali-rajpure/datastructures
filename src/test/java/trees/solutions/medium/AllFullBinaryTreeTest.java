package trees.solutions.medium;

import java.util.List;
import org.junit.Test;
import trees.BinaryTreeNode;

import static org.junit.Assert.*;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/
 *
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 *
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
 *
 * Each node of each tree in the answer must have node.val = 0.
 *
 * You may return the final list of trees in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 *
 */
public class AllFullBinaryTreeTest {

    @Test
    public void allPossibleFBT() {
        AllFullBinaryTree tree = new AllFullBinaryTree();
        final List<BinaryTreeNode> nodes = tree.allPossibleFBT(7,"");
        assertEquals(5,nodes.size());
    }
}
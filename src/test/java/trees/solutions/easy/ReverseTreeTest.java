package trees.solutions.easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import trees.BinarySearchTree;
import trees.BinaryTreeNode;
import trees.LevelOrderTraversal;

import static org.junit.Assert.assertEquals;

public class ReverseTreeTest {

    @Test
    public void reverseTree() {
        ReverseTree reverseTree = new ReverseTree();

        BinaryTreeNode right2 = new BinaryTreeNode(3, null, null);
        BinaryTreeNode left2 = new BinaryTreeNode(1, null, null);
        BinaryTreeNode left7 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode right7 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, left2, right2);
        BinaryTreeNode node7 = new BinaryTreeNode(7, left7, right7);
        BinaryTreeNode root = new BinaryTreeNode(4, node2, node7);

        BinarySearchTree.inorder(root);

        final BinaryTreeNode mirror = reverseTree.invertTree(root);

        final List<ArrayList<Integer>> lists = LevelOrderTraversal.levelOrderTraversal(mirror);
        final String collect = lists
            .stream()
            .flatMap(Collection::stream)
            .map(String::valueOf)
            .collect(Collectors.joining(","));
        assertEquals("4,7,2,9,6,3,1", collect);

    }
}
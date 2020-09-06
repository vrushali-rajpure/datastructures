package trees.solutions.medium;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import trees.BinaryTreeNode;

public class InOrderIterativeTest {

    @Test
    public void inorder() {

        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2,node3,null);
        BinaryTreeNode root = new BinaryTreeNode(1, null,node2);

        final List<Integer> inorder = InOrderIterative.inorder(root);
        System.out.println(inorder);
    }
}
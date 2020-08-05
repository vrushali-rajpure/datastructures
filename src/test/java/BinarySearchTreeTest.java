import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void levelOrderTraversal() {

        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, null);
        BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);

        BinarySearchTree.levelOrderTraversal(root);

    }

    @Test
    public void constructTreeFromPreAndInorderExpression() {
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, null);
        BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);

        final int[] preOrder = {1, 2, 4, 5, 3, 6};
        final int[] inOrder = {4, 2, 5, 1, 6, 3};
        final BinaryTreeNode node = BinarySearchTree.constructTreeFromPreAndInorderExpression(preOrder, inOrder);

        BinarySearchTree.levelOrderTraversal(node);
    }

    @Test
    public void constructTreeFromPostAndInorderExpression() {
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, null);
        BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);

        final int[] postOrder = {4, 5, 2, 6,3,1};
        final int[] inOrder = {4, 2, 5, 1, 6, 3};
        final BinaryTreeNode node = BinarySearchTree.constructTreeFromPostAndInorderExpression(postOrder, inOrder);

        BinarySearchTree.levelOrderTraversal(node);
    }

    @Test
    public void mirror() {
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, null);
        BinaryTreeNode root = new BinaryTreeNode(1, node2, node3);

        BinarySearchTree.inorder(root);

        final BinaryTreeNode mirror = BinarySearchTree.mirror(root);

        System.out.println("Mirror");
        BinarySearchTree.inorder(mirror);
    }
}
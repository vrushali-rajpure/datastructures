package trees;

public class BSTFromPostAndInorder {

    public static BinaryTreeNode constructTreeFromPostAndInorderExpression(int[] postOrder, int[] inOrder) {

        if (postOrder.length == 0 || inOrder.length != postOrder.length) {
            return null;
        }
        return constructPostIn(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    //not working .. investigate
    private static BinaryTreeNode constructPostIn(int[] postOrder, int postStart, int postEnd, int[] inOrder,
        int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        final int data = postOrder[postEnd];
        BinaryTreeNode node = new BinaryTreeNode(data);
        int offset = inStart;
        for (; offset < inEnd; offset++) {
            if (inOrder[offset] == data) {
                break;
            }
        }
        node.left = constructPostIn(postOrder, postStart, postStart + offset - inStart - 1, inOrder, inStart, offset - 1);
        node.right = constructPostIn(postOrder, postStart + offset - inStart, postEnd - 1, inOrder, offset + 1, inEnd);
        return node;
    }

}

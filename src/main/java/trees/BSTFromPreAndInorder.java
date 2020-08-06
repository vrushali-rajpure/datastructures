package trees;

public class BSTFromPreAndInorder {

    public static BinaryTreeNode constructTreeFromPreAndInorderExpression(int[] pre, int[] in) {
        if (pre.length == 0 || in.length != pre.length) {
            return null;
        }
        return constructPreIn(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private static BinaryTreeNode constructPreIn(int[] pre, int preStart, int preEnd, int[] in, int inStart,
        int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        final int data = pre[preStart];
        BinaryTreeNode node = new BinaryTreeNode(data);
        int offset = inStart;
        for (; offset < inEnd; offset++) {
            if (in[offset] == data) {
                break;
            }
        }
        node.left = constructPreIn(pre, preStart + 1, preStart + offset - inStart, in, inStart, offset - 1);
        node.right = constructPreIn(pre, preStart + offset - inStart + 1, preEnd, in, offset + 1, inEnd);
        return node;
    }
}

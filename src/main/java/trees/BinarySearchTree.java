package trees;

public class BinarySearchTree {

    // NOT WORKING :: NEED TO FIX
    static boolean treeEqual(BinaryTreeNode t1, BinaryTreeNode t2) {

        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.data != t2.data)
            return false;

        else
            return treeEqual(t1.left, t2.left) && treeEqual(t1.left, t2.left);
    }

    public static void inorder(BinaryTreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static BinaryTreeNode mirror(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        BinaryTreeNode left = mirror(root.left);
        BinaryTreeNode right = mirror(root.right);

        BinaryTreeNode node = new BinaryTreeNode(root.data);
        node.right = left;
        node.left = right;
        return node;
    }
}
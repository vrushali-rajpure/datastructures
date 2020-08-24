package trees.solutions.easy;

import trees.BinaryTreeNode;

public class LowestCommonAncestor {

    // O(N)
    static BinaryTreeNode lca(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        if ( root == null)
            return null;

        if( root == a || root  == b) {
            return root;
        }
        BinaryTreeNode left = lca(root.left,a,b);
        BinaryTreeNode right = lca(root.right,a,b);

        if( left != null && right != null)
            return root;

        if( left == null && right == null)
            return null;

        return left != null ? left : right;

    }
}

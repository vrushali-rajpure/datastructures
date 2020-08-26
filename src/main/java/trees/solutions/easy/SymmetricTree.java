package trees.solutions.easy;

import javax.swing.tree.TreeNode;
import trees.BinaryTreeNode;

public class SymmetricTree {

    public boolean isSymmetric(BinaryTreeNode root) {

        return isMirror(root,root);
    }

    private boolean isMirror(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.data == t2.data) &&
            isMirror(t1.left,t2.right) &&
            isMirror(t1.right,t2.left);
    }

}


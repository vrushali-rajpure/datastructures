package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    public static void levelOrderTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            System.out.println("---------NEXT----------");
            final BinaryTreeNode temp = queue.poll();
            System.out.print("temp:" + temp);
            if (temp != null) {
                curr.add(temp.data);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                System.out.print("--queue:" + queue);
            } else {
                ArrayList<Integer> c_curr = new ArrayList<>(curr);
                result.add(c_curr);
                curr.clear();
                if (!queue.isEmpty()) {
                    System.out.print("::adding null::");
                    queue.offer(null);
                }
            }
            System.out.print("-- curr:" + curr);
            System.out.println("----");
        }

        System.out.println(result);
    }

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
        node.left = constructPostIn(postOrder, postStart , postStart + offset - inStart - 1, inOrder, inStart, offset - 1);
        node.right = constructPostIn(postOrder, postStart + offset - inStart , postEnd - 1, inOrder, offset + 1, inEnd);
        return node;
    }

    public static void inorder(BinaryTreeNode root)
    {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }

    public static BinaryTreeNode mirror(BinaryTreeNode root) {
        if( root == null) {
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

class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(int data) {
        this.data = data;
    }

    @Override public String toString() {
        return "{" +
            "data=" + data +
            '}';
    }

}

package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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
}

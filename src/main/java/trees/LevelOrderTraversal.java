package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Collections.emptyList;

public class LevelOrderTraversal {

    public static List<ArrayList<Integer>> levelOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            return emptyList();
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            if (temp != null) {
                curr.add(temp.data);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            } else {
                ArrayList<Integer> c_curr = new ArrayList<>(curr);
                result.add(c_curr);
                curr.clear();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }


        return result;
    }
}

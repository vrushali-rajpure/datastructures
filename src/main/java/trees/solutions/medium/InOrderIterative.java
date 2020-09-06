package trees.solutions.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import trees.BinaryTreeNode;

public class InOrderIterative {

    public static List<Integer> inorder(BinaryTreeNode root) {

        Stack<BinaryTreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        BinaryTreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.data);
            current = current.right;
        }
        return result;
    }
}

package trees.solutions.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * Example 1:
 *            1
 *      3     2       4
 *  5    6
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override public String toString() {
        return "Node{" +
            "val=" + val +
            '}';
    }
}

public class MaxDepthNArrayTree {

    public static int maxDepth(Node root) {
        System.out.println(root);
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        List<Integer> heights = new LinkedList<>();
        for (Node item : root.children) {
            heights.add(maxDepth(item));
        }
        return Collections.max(heights) + 1;
    }

    public static void main(String[] args) {

        final Node second1 = new Node(5);
        final Node second2 = new Node(6);
        final Node first1 = new Node(3, asList(second1, second2));
        final Node first2 = new Node(2);
        final Node first3 = new Node(4);
        final Node root = new Node(1, asList(first1, first2, first3));

        final int depth = MaxDepthNArrayTree.maxDepth(root);
        System.out.println(depth);
    }

}
